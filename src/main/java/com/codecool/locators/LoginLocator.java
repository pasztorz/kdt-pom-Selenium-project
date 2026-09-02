package com.codecool.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginLocator {

  @FindBy(css = ".form-card")
  private WebElement loginForm;

  @FindBy(id = "login-email")
  private WebElement emailField;

  @FindBy(id = "login-password")
  private WebElement passwordField;

  @FindBy(css = "button[type='submit']")
  private WebElement signInButton;

  @FindBy(css = "a[data-testid='goto-signup']")
  private WebElement createButton;

  @FindBy(css = "div[data-testid='login-email-error']")
  private WebElement emailError;

  @FindBy(css = "div[data-testid='login-password-error']")
  private WebElement passwordError;

  @FindBy(css = "div[role='alert']")
  private WebElement invalidCredetialsError;

  public LoginLocator(WebDriver driver) {
    PageFactory.initElements(driver, this);
  }

  public WebElement getLoginForm() {
    return loginForm;
  }

  public WebElement getEmailField() {
    return emailField;
  }

  public WebElement getPasswordField() {
    return passwordField;
  }

  public WebElement getSignInButton() {
    return signInButton;
  }

  public WebElement getCreateButton() {
    return createButton;
  }

  public WebElement getEmailError() {
    return emailError;
  }

  public WebElement getPasswordError() {
    return passwordError;
  }

  public WebElement getCredentialsError() {
    return invalidCredetialsError;
  }
}
