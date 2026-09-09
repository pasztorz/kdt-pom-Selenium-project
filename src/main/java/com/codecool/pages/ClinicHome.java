package com.codecool.pages;

import com.codecool.locators.ClinicHomeLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ClinicHome extends Page {
  private static final String URL = "https://playground.qatools.dev/clinic";

  private final ClinicHomeLocator locator;
  private final WebDriverWait wait;

  public ClinicHome(WebDriver driver) {
    super(driver, URL);

    this.locator = new ClinicHomeLocator(driver);
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  }
}
