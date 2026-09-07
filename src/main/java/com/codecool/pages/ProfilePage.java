package com.codecool.pages;

import com.codecool.locators.ProfileLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ProfilePage extends Page {
  private static final String URL = "https://playground.qatools.dev/profile";

  private final ProfileLocator locator;
  private final WebDriverWait wait;

  public ProfilePage(WebDriver driver) {
    super(driver, URL);

    this.locator = new ProfileLocator(driver);
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  }

  public boolean isPasswordDisplayed(String password) {
    List<String> formElementsTexts = listElementTexts();
    return formElementsTexts.contains(password);
  }

  public List<String> listElementTexts() {
    List<WebElement> profileFields = locator.getProfileFields();
    List<String> texts = new ArrayList<>();

    wait.until(ExpectedConditions.visibilityOf(locator.getProfileForm()));

    for (WebElement element : profileFields) {
      String innerText = element.getAttribute("innerText");
      String placeHolder = element.getAttribute("placeholder");
      texts.add(innerText);
      texts.add(placeHolder);
    }

    return texts;
  }

  public void clickProfileTabButton() {
    wait.until(ExpectedConditions.elementToBeClickable(locator.getProfileTabButton()));
    locator.getProfileTabButton().click();
  }
}
