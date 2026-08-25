package com.codecool.pages;

import org.openqa.selenium.WebDriver;

import java.net.URL;

public class DoctorsPage extends Page {
  private static final String URL = "https://playground.qatools.dev/clinic/doctors";

  public DoctorsPage(WebDriver driver) {
    super(driver, URL);
  }
}
