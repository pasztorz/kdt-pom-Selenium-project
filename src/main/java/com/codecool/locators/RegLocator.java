package com.codecool.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegLocator {

  @FindBy(id = "signup-name")
  WebElement fullNameFld;

  @FindBy(id = "signup-email")
  WebElement signUpEmailFld;

  @FindBy(id = "signup-password")
  WebElement signUpPwFld;

  @FindBy(id = "signup-confirm")
  WebElement signUpConfFld;

  @FindBy(id = "signup-country")
  WebElement countryFld;

  @FindBy(css = "div[class='row'] label:nth-child(1)")
  WebElement femaleSelector;

  @FindBy(css = "div[class='row'] label:nth-child(1)")
  WebElement maleSelector;

  @FindBy(css = "label:nth-child(3)")
  WebElement otherSelector;

  @FindBy(css = "div:nth-child(7) label:nth-child(1)")
  WebElement agreeSelector;

  @FindBy(css = "button[type='submit']")
  WebElement regBtn;

  @FindBy(css = "a[data-testid='goto-login']")
  WebElement regSignInBtn;

  public RegLocator(WebDriver driver) {
    PageFactory.initElements(driver, this);
  }

  public WebElement getFullNameFld() {
    return fullNameFld;
  }

  public WebElement getSignUpEmailFld() {
    return signUpEmailFld;
  }

  public WebElement getSignUpPwFld() {
    return signUpPwFld;
  }

  public WebElement getSignUpConfFld() {
    return signUpConfFld;
  }

  public WebElement getCountryFld() {
    return countryFld;
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

  public WebElement getRegBtn() {
    return regBtn;
  }

  public WebElement getRegSignInBtn() {
    return regSignInBtn;
  }
}
