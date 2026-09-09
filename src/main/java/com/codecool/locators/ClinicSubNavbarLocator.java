package com.codecool.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ClinicSubNavbarLocator {

  @FindBy(css = "nav[aria-label='Clinic navigation']")
  private WebElement links;

  @FindBys({
    @FindBy(css = "nav[aria-label='Clinic navigation']"),
    @FindBy(tagName = "a")
  })
  List<WebElement> linkButtonList;

  @FindBy(css = ".clinic-subnav-link[data-testid='clinic-nav-doctors']")
  private WebElement navbarFindDoctorBtn;

  @FindBy(css = ".clinic-subnav-link[data-testid='clinic-nav-appointments']")
  private WebElement navbarAppointmentsBtn;

  public ClinicSubNavbarLocator(WebDriver driver) {
    PageFactory.initElements(driver, this);
  }

  public WebElement getLinks() {
    return links;
  }

  public List<WebElement> getLinkButtonList() {
    return linkButtonList;
  }

  public WebElement getNavbarFindDoctorBtn() {
    return navbarFindDoctorBtn;
  }

  public WebElement getNavbarAppointmentsBtn() {
    return navbarAppointmentsBtn;
  }
}
