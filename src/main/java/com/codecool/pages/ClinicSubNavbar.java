package com.codecool.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ClinicSubNavbar {
  private final ClinicSubNavbarLocator locator;
  private final WebDriverWait wait;

  public ClinicSubNavbar(WebDriver driver) {
    this.locator = new ClinicSubNavbarLocator(driver);
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  }

  public boolean containsMyAppointments() {
    List<String> linkButtonsTextList = getLinkButtonsTexts();
    return linkButtonsTextList.contains("My appointment");
  }

  public List<String> getLinkButtonsTexts() {
    wait.until(ExpectedConditions.visibilityOf(locator.getLinks()));
    List<String> subNavbarLinkButtonTextList = new ArrayList<>();

    for (WebElement element : locator.getLinkButtonList) {
      String buttonText = element.getText();
      subNavbarLinkButtonTextList.add(buttonText);
    }

    return subNavbarLinkButtonTextList;
  }
}
