package com.codecool.pages;

import org.openqa.selenium.WebDriver;

public class Home extends Page {
  private static final String URL = "https://playground.qatools.dev";

  public Home(WebDriver driver) {
    super(driver, URL);
  }
}
