package com.codecool.pages;

import com.codecool.locators.ClinicSubNavbarLocator;
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

  public void clickNavbarAppointmentsBtn() {
    wait.until(ExpectedConditions.elementToBeClickable(locator.getNavbarAppointmentsBtn()));
    locator.getNavbarAppointmentsBtn().click();
  }

  public boolean hasButtonWithText(String buttonText) {
    List<String> linkButtonsTextList = getLinkButtonTextList();
    return linkButtonsTextList.contains(buttonText);
  }

  public List<String> getLinkButtonTextList() {
    List<WebElement> linkButtonList = locator.getLinkButtonList();
    List<String> linkButtonsTextList = new ArrayList<>();

    wait.until(ExpectedConditions.visibilityOf(locator.getLinks()));

    for (WebElement element : linkButtonList) {
      String buttonText = element.getText();
      linkButtonsTextList.add(buttonText);
    }

    return linkButtonsTextList;
  }
}
