package com.codecool.pages;

import org.openqa.selenium.WebDriver;

public class RegistrationPage extends Page {
  private static final String URL ="https://playground.qatools.dev/signup";

  public RegistrationPage(WebDriver driver) {
    super(driver, URL);
  }
}
