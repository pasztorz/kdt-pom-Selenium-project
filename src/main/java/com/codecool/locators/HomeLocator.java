package com.codecool.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeLocator {

  @FindBy(css = ".hero-cta-app.hero-cta-clinic")
  private WebElement clinicNavBtn;

  public HomeLocator(WebDriver driver) {
    PageFactory.initElements(driver, this);
  }

  public WebElement getClinicNavBtn() {
    return clinicNavBtn;
  }
}
