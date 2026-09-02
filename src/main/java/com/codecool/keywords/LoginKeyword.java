package com.codecool.keywords;

import com.codecool.pages.LoginPage;
import com.codecool.pages.Navbar;
import com.codecool.pages.SignUpPage;
import org.openqa.selenium.WebDriver;

public class LoginKeyword {
  private final Navbar navbar;
  private final SignUpPage signUpPage;
  private final LoginPage loginPage;

  public LoginKeyword(WebDriver driver) {
    this.navbar = new Navbar(driver);
    this.signUpPage = new SignUpPage(driver);
    this.loginPage = new LoginPage(driver);
  }

  public String getErrorMessage(String parameter) {
    String result = "";

    switch (parameter) {
      case "email" -> result = loginPage.getEmailErrorText();
      case "password" -> result = loginPage.getPasswordErrorText();
      case "credentials" -> result = loginPage.getCredentialsErrorText();
    }

    return result;
  }

  public void login(String email, String password) {
    loginPage.enterEmail(email);
    loginPage.enterPassword(password);
    loginPage.clickSingIn();
  }

  public void openFromSignUpPage() {
    signUpPage.openPage();
    signUpPage.clickSignInBtn();
  }

  public void openFromNavbar() {
    navbar.clickNavbarSignInBtn();
  }
}
