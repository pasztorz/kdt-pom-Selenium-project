package com.codecool.keywords;

import com.codecool.pages.LoginPage;
import com.codecool.pages.SignUpPage;
import org.openqa.selenium.WebDriver;

public class SignUpKeyword {
  private final LoginPage loginPage;
  private final SignUpPage signUpPage;

  public SignUpKeyword(WebDriver driver) {
    this.loginPage = new LoginPage(driver);
    this.signUpPage = new SignUpPage(driver);
  }

  public void signUp(String firstName, String  lastName) {
    signUpPage.enterFullName(firstName, lastName);
    signUpPage.enterEmail(firstName, lastName);
    signUpPage.enterPassword(firstName, lastName);
    signUpPage.enterConfirmedPassword(firstName, lastName);
  }

  public void openFromLoginPage() {
    loginPage.openPage();
    loginPage.clickCreateBtn();
  }
}
