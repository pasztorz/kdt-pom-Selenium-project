package com.codecool.pages;

import org.openqa.selenium.WebDriver;

public class ClinicHome extends Page {
  private static final String URL = "https://playground.qatools.dev/clinic";

  public ClinicHome(WebDriver driver) {
    super(driver, URL);
  }
}
