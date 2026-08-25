package com.codecool.pages;

import org.openqa.selenium.WebDriver;

public class SignupPage extends Page {
  private static final String URL ="https://playground.qatools.dev/signup";

  public SignupPage(WebDriver driver) {
    super(driver, URL);
  }
}
