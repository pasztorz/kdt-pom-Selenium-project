package com.codecool.keywords;

import com.codecool.pages.HomePage;
import org.openqa.selenium.WebDriver;

public class ClinicKeyword {
  private final HomePage homePage;

  public ClinicKeyword(WebDriver driver) {
    this.homePage = new HomePage(driver);
  }

  public void openClinicFromNewHome(WebDriver newDriver) {
    ClinicKeyword newClinicKeyword = new ClinicKeyword(newDriver);

    newClinicKeyword.openClinicFromHomeWithClinicButton();
  }

  public void openClinicFromHomeWithClinicButton() {
    homePage.clickClinicButton();
  }
}
