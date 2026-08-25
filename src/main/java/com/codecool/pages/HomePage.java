package com.codecool.pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends Page {
  private static final String URL = "https://playground.qatools.dev/clinic";

  public HomePage(WebDriver driver) {
    super(driver, URL);
  }
}
