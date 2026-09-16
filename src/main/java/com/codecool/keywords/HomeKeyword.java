package com.codecool.keywords;

import com.codecool.pages.HomePage;
import org.openqa.selenium.WebDriver;

public class HomeKeyword {
  private final HomePage homePage;

  public HomeKeyword(WebDriver driver) {
    this.homePage = new HomePage(driver);
  }

  public void openNewHomeWithoutPopUp(WebDriver newDriver) {
    HomeKeyword newHomeKeyword = new HomeKeyword(newDriver);

    newHomeKeyword.openHomeWithoutPopUp();
  }

  public void openNewHomeWithPopUp(WebDriver newDriver) {
    HomeKeyword newHomeKeyword = new HomeKeyword(newDriver);

    newHomeKeyword.openHomeAndSkipPopUp();
  }

  public void openHomeWithoutPopUp() {
    homePage.openPage();
  }

  public void openHomeAndSkipPopUp() {
    homePage.openPage();
    homePage.skipWelcome();
  }
}
