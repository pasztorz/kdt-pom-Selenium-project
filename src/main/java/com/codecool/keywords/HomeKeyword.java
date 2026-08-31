package com.codecool.keywords;

import com.codecool.pages.Home;
import org.openqa.selenium.WebDriver;

public class HomeKeyword {
  private final Home home;

  public HomeKeyword(WebDriver driver) {
    this.home = new Home(driver);
  }

  public void openHome() {
    home.openPage();
    home.skipWelcome();
  }
}
