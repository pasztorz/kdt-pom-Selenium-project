package com.codecool.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.LinkedHashSet;
import java.util.List;

public class ClinicHomeLocator {

  @FindBy(css = ".clinic-btn-primary")
  private WebElement findDoctorBtn;

  @FindBy(css = ".clinic-btn-ghost")
  private WebElement appointmentsBtn;

  @FindBy(css = ".clinic-hero-actions")
  private WebElement titleSectionButtonCollector;

  @FindBys({
    @FindBy(css = ".clinic-hero-actions"),
    @FindBy(tagName = "a")
  })
  List<WebElement> clinicHomeButtonList;

  public ClinicHomeLocator(WebDriver driver) {
    PageFactory.initElements(driver, this);
  }

  public WebElement getTitleSectionButtonCollector() {
    return titleSectionButtonCollector;
  }

  public List<WebElement> getClinicHomeButtonList() {
    return clinicHomeButtonList;
  }

  public WebElement getFindDoctorBtn() {
    return findDoctorBtn;
  }

  public WebElement getAppointmentsBtn() {
    return appointmentsBtn;
  }
}
