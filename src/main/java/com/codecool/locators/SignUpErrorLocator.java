package com.codecool.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpErrorLocator {

  @FindBy(css = "div[data-testid='signup-name-error']")
  private WebElement nameError;

  @FindBy(css = "div[data-testid='signup-email-error']")
  private WebElement emailError;

  @FindBy(css = "div[data-testid='signup-password-error']")
  private WebElement passwordError;

  @FindBy(css = "div[data-testid='signup-confirm-error']")
  private WebElement confirmedPasswordError;

  @FindBy(css = "div[data-testid='signup-country-error']")
  private WebElement countryError;

  @FindBy(css = "div[data-testid='signup-gender-error']")
  private WebElement genderError;

  @FindBy(css = "div[data-testid='signup-agree-error']")
  private WebElement agreementError;

  public SignUpErrorLocator(WebDriver driver) {
    PageFactory.initElements(driver, this);
  }

  public WebElement getNameError() {
    return nameError;
  }

  public WebElement getEmailError() {
    return emailError;
  }

  public WebElement getPasswordError() {
    return passwordError;
  }

  public WebElement getConfirmedPasswordError() {
    return confirmedPasswordError;
  }

  public WebElement getCountryError() {
    return countryError;
  }

  public WebElement getGenderError() {
    return genderError;
  }

  public WebElement getAgreementError() {
    return agreementError;
  }
}
