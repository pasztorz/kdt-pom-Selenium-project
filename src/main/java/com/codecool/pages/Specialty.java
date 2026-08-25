package com.codecool.pages;

import org.openqa.selenium.WebDriver;

public class Specialty extends Page {

  public Specialty(WebDriver driver, String specialtyUrl) {
    super(driver, "https://playground.qatools.dev/clinic/doctors?specialty=" + specialtyUrl);
  }


}
