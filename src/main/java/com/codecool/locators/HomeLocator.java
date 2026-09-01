package com.codecool.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeLocator {

  @FindBy(xpath = "//button[normalize-space()='Skip tour']")
  private WebElement skipTourButton;

  @FindBy(css = ".hero-cta-app.hero-cta-clinic")
  private WebElement clinicButton;

  public HomeLocator(WebDriver driver) {
    PageFactory.initElements(driver, this);
  }

  public WebElement getSkipTourButton() {
    return skipTourButton;
  }

  public WebElement getClinicButton() {
    return clinicButton;
  }
}
