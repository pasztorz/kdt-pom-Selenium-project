package com.codecool.pages;

import org.openqa.selenium.WebDriver;

public class RegisterPage extends Page {
  private static final String URL ="https://playground.qatools.dev/signup";

  public RegisterPage(WebDriver driver) {
    super(driver, URL);
  }
}
