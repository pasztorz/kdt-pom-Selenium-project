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

  public String getErrorMessage() {
    return loginPage.getEmailErrorText();
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
