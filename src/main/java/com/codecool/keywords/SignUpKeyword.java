package com.codecool.keywords;

import com.codecool.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class SignUpKeyword {
  private final LoginPage loginPage;

  public SignUpKeyword(WebDriver driver) {
    this.loginPage = new LoginPage(driver);
  }

  public void openFromLoginPage() {
    loginPage.openPage();
    loginPage.clickCreateBtn();
  }
}
