package com.codecool.pages;

import org.openqa.selenium.WebDriver;

public class RegPage extends Page {
  private static final String URL ="https://playground.qatools.dev/signup";

  public RegPage(WebDriver driver) {
    super(driver, URL);
  }
}
