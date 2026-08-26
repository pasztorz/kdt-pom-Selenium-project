package com.codecool.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginLocator {

  @FindBy(css = ".form-card")
  WebElement lgnForm;

  @FindBy(id = "login-email")
  WebElement loginEmailFld;

  @FindBy(id = "login-password")
  WebElement loginPwFld;

  @FindBy(css = "button[type='submit']")
  WebElement signInBtn;

  @FindBy(css = "a[data-testid='goto-signup']")
  WebElement registerBtn;

  public LoginLocator(WebDriver driver) {
    PageFactory.initElements(driver, this);
  }

  public WebElement getLgnForm() {
    return lgnForm;
  }

  public WebElement getLoginEmailFld() {
    return loginEmailFld;
  }

  public WebElement getLoginPwFld() {
    return loginPwFld;
  }

  public WebElement getSignInBtn() {
    return signInBtn;
  }

  public WebElement getRegisterBtn() {
    return registerBtn;
  }
}
