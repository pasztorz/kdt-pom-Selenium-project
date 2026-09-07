package com.codecool.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProfileLocator {

  @FindBy(xpath = "//button[normalize-space()='Profile']")
  private WebElement profileTabButton;

  @FindBy(css = ".card")
  private WebElement profileForm;

  @FindBys({
    @FindBy(css = ".card"),
    @FindBy(tagName = "div")
  })
  private List<WebElement> profileFields;

  public ProfileLocator(WebDriver driver) {
    PageFactory.initElements(driver, this);
  }

  public List<WebElement> getProfileFields() {
    return profileFields;
  }

  public WebElement getProfileForm() {
    return profileForm;
  }

  public WebElement getProfileTabButton() {
    return profileTabButton;
  }
}
