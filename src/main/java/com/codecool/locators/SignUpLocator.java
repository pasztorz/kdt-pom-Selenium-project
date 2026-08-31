package com.codecool.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpLocator {

  @FindBy(css = ".form-card")
  private WebElement registrationForm;

  @FindBy(id = "signup-name")
  private WebElement nameField;

  @FindBy(id = "signup-email")
  private WebElement emailField;

  @FindBy(id = "signup-password")
  private WebElement passwordField;

  @FindBy(id = "signup-confirm")
  private WebElement confirmField;

  @FindBy(id = "signup-country")
  private WebElement countryField;

  @FindBy(css = "input[value='Female']")
  private WebElement femaleSelector;

  @FindBy(css = "input[value='Male']")
  private WebElement maleSelector;

  @FindBy(css = "input[value='Other']")
  private WebElement otherSelector;

  @FindBy(css = "input[name='agree']")
  private WebElement agreeSelector;

  @FindBy(css = "button[type='submit']")
  private WebElement submitButton;

  @FindBy(css = "a[data-testid='goto-login']")
  private WebElement navToSignInBtn;

  public SignUpLocator(WebDriver driver) {
    PageFactory.initElements(driver, this);
  }

  public WebElement getRegistrationForm() {
    return registrationForm;
  }

  public WebElement getNameField() {
    return nameField;
  }

  public WebElement getEmailField() {
    return emailField;
  }

  public WebElement getPasswordField() {
    return passwordField;
  }

  public WebElement getConfirmField() {
    return confirmField;
  }

  public WebElement getCountryField() {
    return countryField;
  }

  public WebElement getFemaleSelector() {
    return femaleSelector;
  }

  public WebElement getMaleSelector() {
    return maleSelector;
  }

  public WebElement getOtherSelector() {
    return otherSelector;
  }

  public WebElement getAgreeSelector() {
    return agreeSelector;
  }

  public WebElement getSubmitButton() {
    return submitButton;
  }

  public WebElement getNavToSignInBtn() {
    return navToSignInBtn;
  }
}
