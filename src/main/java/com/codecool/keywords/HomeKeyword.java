package com.codecool.keywords;

import com.codecool.pages.HomePage;
import org.openqa.selenium.WebDriver;

public class HomeKeyword {
  private final HomePage homePage;

  public HomeKeyword(WebDriver driver) {
    this.homePage = new HomePage(driver);
  }

  public void reOpenHomeWithNoIncognitoBrowser(WebDriver newDriver) {
    newDriver.get(homePage.getUrl());
  }

  public void reOpenHomeInIncognitoBrowser(WebDriver newDriver) {
    newDriver.get(homePage.getUrl());
    homePage.skipWelcome();
  }

  public void openHome() {
    homePage.openPage();
    homePage.skipWelcome();
  }
}
