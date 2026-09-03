package com.codecool.keywords;

import com.codecool.pages.LoginPage;
import com.codecool.pages.Navbar;
import com.codecool.pages.SignUpPage;
import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.WebDriver;

public class LoginKeyword {
  private static final Dotenv DOTENV = Dotenv.load();
  private static final String EMAIL = DOTENV.get("DEFAULT_TEST_USER_EMAIL");
  private static final String PASSWORD = DOTENV.get("DEFAULT_TEST_USER_PASSWORD");

  private final Navbar navbar;
  private final SignUpPage signUpPage;
  private final LoginPage loginPage;

  public LoginKeyword(WebDriver driver) {
    this.navbar = new Navbar(driver);
    this.signUpPage = new SignUpPage(driver);
    this.loginPage = new LoginPage(driver);
  }

  public void login(String email, String password) {
    loginPage.enterEmail(email);
    loginPage.enterPassword(password);
    loginPage.clickSingIn();
  }

  public void login() {
    loginPage.enterEmail(EMAIL);
    loginPage.enterPassword(PASSWORD);
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
