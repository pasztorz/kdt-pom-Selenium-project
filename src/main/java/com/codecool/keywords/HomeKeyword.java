package com.codecool.keywords;

import com.codecool.pages.HomePage;
import org.openqa.selenium.WebDriver;

public class HomeKeyword {
  private final HomePage homePage;

  public HomeKeyword(WebDriver driver) {
    this.homePage = new HomePage(driver);
  }

  public void openHome() {
    homePage.openPage();
    homePage.skipWelcome();
  }
}
