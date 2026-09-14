package com.codecool.keywords;

import com.codecool.pages.HomePage;
import org.openqa.selenium.WebDriver;

public class HomeKeyword {
  private final HomePage homePage;

  public HomeKeyword(WebDriver driver) {
    this.homePage = new HomePage(driver);
  }

  public void openNewPersistentHome(WebDriver newDriver) {
    HomeKeyword newHomeKeyword = new HomeKeyword(newDriver);

    newHomeKeyword.openHomeWithoutPopUp();
  }

  public void openNewFreshHome(WebDriver newDriver) {
    HomeKeyword newHomeKeyword = new HomeKeyword(newDriver);

    newHomeKeyword.openHomeAndHandleWelcomePopUp();
  }

  public void openHomeWithoutPopUp() {
    homePage.openPage();
  }

  public void openHomeAndHandleWelcomePopUp() {
    homePage.openPage();
    homePage.skipWelcome();
  }
}
