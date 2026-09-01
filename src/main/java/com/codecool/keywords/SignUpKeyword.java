package com.codecool.keywords;

import com.codecool.pages.LoginPage;
import com.codecool.pages.SignUpPage;
import com.codecool.service.CredentialsProvider;
import org.openqa.selenium.WebDriver;

public class SignUpKeyword {
  private final LoginPage loginPage;
  private final SignUpPage signUpPage;

  public SignUpKeyword(WebDriver driver) {
    this.loginPage = new LoginPage(driver);
    this.signUpPage = new SignUpPage(driver);
  }

  public void signUp(String firstName, String  lastName) {
    CredentialsProvider credentialsProvider = new CredentialsProvider(firstName, lastName);
    String fullName = credentialsProvider.createTestFullName();
    String email = credentialsProvider.createTestEmail();
    String password = credentialsProvider.createTestPassword();
    System.out.println(password);

    signUpPage.enterFullName(fullName);
    signUpPage.enterEmail(email);
    signUpPage.enterPassword(password);
    signUpPage.enterConfirmedPassword(password);
  }

  public void openFromLoginPage() {
    loginPage.openPage();
    loginPage.clickCreateBtn();
  }
}
