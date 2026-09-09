package com.codecool.keywords;

import com.codecool.pages.ClinicHome;
import com.codecool.pages.ClinicSubNavbar;
import org.openqa.selenium.WebDriver;

public class ClinicKeyword {
  private final ClinicHome clinicHome;
  private final ClinicSubNavbar clinicSubNavbar;

  public ClinicKeyword(WebDriver driver) {
    this.clinicHome = new ClinicHome(driver);
    this.clinicSubNavbar = new ClinicSubNavbar(driver);
  }

  public void openClinicWithNavButton() {
    clinicSubNavbar.clickNavbarAppointmentsBtn();
  }
}
