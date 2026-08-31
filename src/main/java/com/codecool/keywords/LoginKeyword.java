package com.codecool.keywords;

import com.codecool.pages.Navbar;
import com.codecool.pages.SignUpPage;
import org.openqa.selenium.WebDriver;

public class LoginKeyword {
  private final Navbar navbar;
  private final SignUpPage signUpPage;

  public LoginKeyword(WebDriver driver) {
    this.navbar = new Navbar(driver);
    this.signUpPage = new SignUpPage(driver);
  }

  public void openFromNavbar() {
    navbar.clickNavbarSignInBtn();
  }

  public void openFromSignUpPage() {
    signUpPage.openPage();
    signUpPage.clickSignInBtn();
  }
}
