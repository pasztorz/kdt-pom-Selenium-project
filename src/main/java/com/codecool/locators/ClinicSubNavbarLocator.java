package com.codecool.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ClinicSubNavbarLocator {

  @FindBy(className = "clinic-subnav-links")
  private WebElement links;

  @FindBys({
    @FindBy(css = "nav[aria-label='Clinic navigation']"),
    @FindBy(tagName = "a")
  })
  List<WebElement> linkButtonList;

  public ClinicSubNavbarLocator(WebDriver driver) {
    PageFactory.initElements(driver, this);
  }

  public WebElement getLinks() {
    return links;
  }

  public List<WebElement> getLinkButtonList() {
    return linkButtonList;
  }
}
