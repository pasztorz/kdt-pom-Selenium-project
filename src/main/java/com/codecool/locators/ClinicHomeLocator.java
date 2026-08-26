package com.codecool.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClinicHomeLocator {

  @FindBy(css = ".clinic-subnav-link[data-testid='clinic-nav-doctors']")
  private WebElement navbarFindDoctor;

  @FindBy(css = ".clinic-subnav-link[data-testid='clinic-nav-appointments']")
  private WebElement navbarAppointments;

  @FindBy(css = ".clinic-btn-primary")
  private WebElement findDoctorBtn;

  @FindBy(css = ".clinic-btn-ghost")
  private WebElement appointmentsBtn;

  public ClinicHomeLocator(WebDriver driver) {
    PageFactory.initElements(driver, this);
  }

  public WebElement getNavbarFindDoctor() {
    return navbarFindDoctor;
  }

  public WebElement getNavbarAppointments() {
    return navbarAppointments;
  }

  public WebElement getFindDoctorBtn() {
    return findDoctorBtn;
  }

  public WebElement getAppointmentsBtn() {
    return appointmentsBtn;
  }
}
