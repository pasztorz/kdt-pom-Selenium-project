package com.codecool.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavbarLocator {

  @FindBy(css = ".btn.nav-cta")
  WebElement navBarSignInBtn;

  public NavbarLocator(WebDriver driver) {
    PageFactory.initElements(driver, this);
  }

  public WebElement getNavBarSignInBtn() {
    return navBarSignInBtn;
  }
}
