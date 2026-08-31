package com.codecool.pages;

import com.codecool.locators.SignUpLocator;
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

  public void clickSignInBtn() {
    wait.until(ExpectedConditions.elementToBeClickable(signUpLocator.getNavToSignInBtn()));
    signUpLocator.getNavToSignInBtn().click();
  }
}
