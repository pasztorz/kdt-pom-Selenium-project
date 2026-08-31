package com.codecool.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClinicHomeLocator {

  @FindBy(css = ".clinic-subnav-link[data-testid='clinic-nav-doctors']")
  private WebElement navbarFindDoctorBtn;

  @FindBy(css = ".clinic-subnav-link[data-testid='clinic-nav-appointments']")
  private WebElement navbarAppointmentsBtn;

  @FindBy(css = ".clinic-btn-primary")
  private WebElement findDoctorBtn;

  @FindBy(css = ".clinic-btn-ghost")
  private WebElement appointmentsBtn;

  public ClinicHomeLocator(WebDriver driver) {
    PageFactory.initElements(driver, this);
  }

  public WebElement getNavbarFindDoctorBtn() {
    return navbarFindDoctorBtn;
  }

  public WebElement getNavbarAppointmentsBtn() {
    return navbarAppointmentsBtn;
  }

  public WebElement getFindDoctorBtn() {
    return findDoctorBtn;
  }

  public WebElement getAppointmentsBtn() {
    return appointmentsBtn;
  }
}
