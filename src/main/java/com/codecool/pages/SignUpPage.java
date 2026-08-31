package com.codecool.pages;

import org.openqa.selenium.WebDriver;

public class SignUpPage extends Page {
  private static final String URL ="https://playground.qatools.dev/signup";

  public SignUpPage(WebDriver driver) {
    super(driver, URL);
  }
}
