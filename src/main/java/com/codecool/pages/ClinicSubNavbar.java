package com.codecool.pages;

import com.codecool.locators.ClinicSubNavbarLocator;
import com.codecool.model.ButtonType;
import com.codecool.model.Visible;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ClinicSubNavbar implements Visible {
  private final ClinicSubNavbarLocator locator;
  private final WebDriverWait wait;

  public ClinicSubNavbar(WebDriver driver) {
    this.locator = new ClinicSubNavbarLocator(driver);
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  }

  @Override
  public boolean hasButtonWithText(String buttonText) {
    return getLinkButtonTextList().contains(buttonText);
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

  public void clickNavbarAppointmentsBtn() {
    wait.until(ExpectedConditions.elementToBeClickable(locator.getNavbarAppointmentsBtn()));
    locator.getNavbarAppointmentsBtn().click();
  }
}
