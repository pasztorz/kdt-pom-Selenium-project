package com.codecool.pages;

import com.codecool.locators.SignUpLocator;
import com.codecool.service.CredentialsProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpPage extends Page {
  private static final String URL ="https://playground.qatools.dev/signup";

  protected SignUpLocator signUpLocator;
  private final WebDriverWait wait;

  public SignUpPage(WebDriver driver) {
    super(driver, URL);
    this.signUpLocator = new SignUpLocator(driver);
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  }

  public void enterConfirmedPassword(String firstName, String lastName) {
    CredentialsProvider credentialsProvider = new CredentialsProvider(firstName, lastName);
    String password = credentialsProvider.createTestPassword();

    wait.until(ExpectedConditions.visibilityOf(signUpLocator.getConfirmField()));
    signUpLocator.getConfirmField().sendKeys(password);
  }

  public void enterPassword(String firstName, String lastName) {
    CredentialsProvider credentialsProvider = new CredentialsProvider(firstName, lastName);
    String password = credentialsProvider.createTestPassword();

    wait.until(ExpectedConditions.visibilityOf(signUpLocator.getPasswordField()));
    signUpLocator.getPasswordField().sendKeys(password);
  }

  public void enterEmail(String firstName, String lastName) {
    CredentialsProvider credentialsProvider = new CredentialsProvider(firstName, lastName);
    String email = credentialsProvider.createTestEmail();

    wait.until(ExpectedConditions.visibilityOf(signUpLocator.getEmailField()));
    signUpLocator.getEmailField().sendKeys(email);
  }

  public void enterFullName(String firstName, String lastName) {
    CredentialsProvider credentialsProvider = new CredentialsProvider(firstName, lastName);
    String fullName = credentialsProvider.createTestFullName();

    wait.until(ExpectedConditions.visibilityOf(signUpLocator.getNameField()));
    signUpLocator.getNameField().sendKeys(fullName);
  }

  public void clickSignInBtn() {
    wait.until(ExpectedConditions.elementToBeClickable(signUpLocator.getNavToSignInBtn()));
    signUpLocator.getNavToSignInBtn().click();
  }
}
