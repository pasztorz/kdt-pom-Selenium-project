package com.codecool.pages;

import org.openqa.selenium.WebDriver;

public class AppointmentsPage extends Page {

  public AppointmentsPage(WebDriver driver, int userId) {
    super(driver, "https://playground.qatools.dev/clinic/appointments" + userId);
  }
}
