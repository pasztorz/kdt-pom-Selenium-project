package com.codecool.pages;

import org.openqa.selenium.WebDriver;

public class LoginPage extends Page {
  private static final String URL = "https://playground.qatools.dev/login";

  public LoginPage(WebDriver driver, String url) {
    super(driver, url);
  }
}
