package com.codecool.keywords;

import com.codecool.locators.SignUpLocator;
import com.codecool.pages.SignUpPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpKeyword {
  protected SignUpLocator signUpLocator;
  private final WebDriverWait wait;
  private final SignUpPage signUpPage;

  public SignUpKeyword(WebDriver driver) {
    this.signUpLocator = new SignUpLocator(driver);
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    this.signUpPage = new SignUpPage(driver);
  }

  public void clickSignInBtn() {
    wait.until(ExpectedConditions.elementToBeClickable(signUpLocator.getNavToSignInBtn()));
    signUpLocator.getNavToSignInBtn().click();
  }
}
