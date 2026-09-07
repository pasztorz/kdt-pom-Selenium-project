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

  public boolean isPasswordExposed(String password) {
    List<String> formElementsTextList = getElementTextList();
    return formElementsTextList.contains(password);
  }

  public List<String> getElementTextList() {
    List<String> texts = getLabelTextList();
    List<String> inputFieldsTexts = getInputFieldTextList();

    texts.addAll(inputFieldsTexts);

    return texts;
  }

  public List<String> getInputFieldTextList() {
    List<WebElement> inputFields = locator.getProfileInputFields();
    List<String> inputTexts = new ArrayList<>();

    wait.until(ExpectedConditions.visibilityOf(locator.getProfileForm()));

    for (WebElement element : inputFields) {
      String defaultInputValue = element.getAttribute("value");
      String placeHolder = element.getAttribute("placeholder");
      assert placeHolder != null;

      if (!placeHolder.isEmpty()) inputTexts.add(placeHolder);
      else inputTexts.add(defaultInputValue);
    }

    return inputTexts;
  }

  public List<String> getLabelTextList() {
    List<WebElement> labels = locator.getProfileLabels();
    List<String> labelTexts = new ArrayList<>();

    wait.until(ExpectedConditions.visibilityOf(locator.getProfileForm()));

    for (WebElement element : labels) {
      String innerText = element.getAttribute("innerText");
      labelTexts.add(innerText);
    }

    return labelTexts;
  }

  public void clickProfileTabButton() {
    wait.until(ExpectedConditions.elementToBeClickable(locator.getProfileTabButton()));
    locator.getProfileTabButton().click();
  }
}
