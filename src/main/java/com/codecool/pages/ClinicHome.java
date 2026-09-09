package com.codecool.pages;

import com.codecool.locators.ClinicHomeLocator;
import org.openqa.selenium.WebDriver;

public class ClinicHome extends Page {
  private static final String URL = "https://playground.qatools.dev/clinic";

  private final ClinicHomeLocator locator;

  public ClinicHome(WebDriver driver) {
    super(driver, URL);

    this.locator = new ClinicHomeLocator(driver);
  }
}
