package com.codecool.pages;

import com.codecool.locators.ClinicHomeLocator;
import com.codecool.model.Visible;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ClinicHome extends Page implements Visible {
  private static final String URL = "https://playground.qatools.dev/clinic";

  private final ClinicHomeLocator locator;
  private final WebDriverWait wait;

  public ClinicHome(WebDriver driver) {
    super(driver, URL);

    this.locator = new ClinicHomeLocator(driver);
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  }

  @Override
  public boolean hasButtonWithText(String buttonText) {
    return getTitleSectionButtonTextList().contains(buttonText);
  }

  public List<String> getTitleSectionButtonTextList() {
    List<WebElement> titleSectionButtonList = locator.getClinicHomeButtonList();
    List<String> buttonTextList = new ArrayList<>();

    wait.until(ExpectedConditions.visibilityOf(locator.getTitleSectionButtonCollector()));

    for (WebElement element : titleSectionButtonList) {
      String buttonText = element.getText();
      buttonTextList.add(buttonText);
    }

    return buttonTextList;
  }
}
