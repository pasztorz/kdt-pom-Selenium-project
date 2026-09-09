package com.codecool.keywords;

import com.codecool.pages.ClinicHome;
import com.codecool.pages.ClinicSubNavbar;
import com.codecool.pages.HomePage;
import org.openqa.selenium.WebDriver;

public class ClinicKeyword {
  private final ClinicHome clinicHome;
  private final ClinicSubNavbar clinicSubNavbar;
  private final HomePage homePage;

  public ClinicKeyword(WebDriver driver) {
    this.clinicHome = new ClinicHome(driver);
    this.clinicSubNavbar = new ClinicSubNavbar(driver);
    this.homePage = new HomePage(driver);
  }

  public void openClinicWithNavButton() {
    homePage.clickClinicButton();
  }
}
