package com.codecool.pages;

import org.openqa.selenium.WebDriver;

public class BookingPage extends Page {

  public BookingPage(WebDriver driver, String doctorName) {
    super(driver, "https://playground.qatools.dev/clinic/book/" + doctorName);
  }
}
