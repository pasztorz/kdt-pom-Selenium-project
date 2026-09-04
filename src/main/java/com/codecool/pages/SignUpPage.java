package com.codecool.pages;

import com.codecool.locators.SignUpErrorLocator;
import com.codecool.locators.SignUpLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpPage extends Page {
  private static final String URL ="https://playground.qatools.dev/signup";

  private final SignUpLocator signUpLocator;
  private final SignUpErrorLocator errorLocator;
  private final WebDriverWait wait;

  public SignUpPage(WebDriver driver) {
    super(driver, URL);
    this.signUpLocator = new SignUpLocator(driver);
    this.errorLocator = new SignUpErrorLocator(driver);
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  }

  /// 3rd & 4th TEST DATA APPROACH (less complex ones) STARTS HERE (invalid_signup_credentials_v3.csv)
  public void enterInput(String fieldName, String input, String confirmation) {

    if (confirmation.isEmpty()) {
      switch (fieldName) {
        case "name" -> enterFullName(input);
        case "email" -> enterEmail(input);
        case "password" -> enterPassword(input);
        case "confirmation" -> enterConfirmedPassword(input);
        case "country" -> selectCountry(input);
        case "gender" -> selectGender(input);
        case "agreement" -> selectAgreement(input);
      }
    } else {
      enterPassword(input);
      enterConfirmedPassword(confirmation);
    }
  }

  /// 2nd TEST DATA APPROACH (2nd most complex) STARTS HERE (invalid_signup_credentials_v2.csv)
  public boolean isErrorDisplayed(String fieldName) {
    boolean isVisible = false;

    switch (fieldName) {
      case "name" -> isVisible = hasNameError();
      case "email" -> isVisible = hasEmailError();
      case "password" -> isVisible = hasPasswordError();
      case "confirmation" -> isVisible = hasConfirmedPasswordError();
      case "country" -> isVisible = hasCountryError();
      case "gender" -> isVisible = hasGenderError();
      case "agreement" -> isVisible = hasAgreementError();
      case "account" -> isVisible = hasAccountError();
    }
    return isVisible;
  }

  public boolean hasAccountError() {
    wait.until(ExpectedConditions.visibilityOf(errorLocator.getExistingAccountError()));
    return errorLocator.getExistingAccountError().isDisplayed();
  }

  public boolean hasAgreementError() {
    wait.until(ExpectedConditions.visibilityOf(errorLocator.getAgreementError()));
    return errorLocator.getAgreementError().isDisplayed();
  }

  public boolean hasGenderError() {
    wait.until(ExpectedConditions.visibilityOf(errorLocator.getGenderError()));
    return errorLocator.getGenderError().isDisplayed();
  }

  public boolean hasCountryError() {
    wait.until(ExpectedConditions.visibilityOf(errorLocator.getCountryError()));
    return errorLocator.getCountryError().isDisplayed();
  }

  public boolean hasConfirmedPasswordError() {
    wait.until(ExpectedConditions.visibilityOf(errorLocator.getConfirmedPasswordError()));
    return errorLocator.getConfirmedPasswordError().isDisplayed();
  }

  public boolean hasPasswordError() {
    wait.until(ExpectedConditions.visibilityOf(errorLocator.getPasswordError()));
    return errorLocator.getPasswordError().isDisplayed();
  }

  public boolean hasEmailError() {
    wait.until(ExpectedConditions.visibilityOf(errorLocator.getEmailError()));
    return errorLocator.getEmailError().isDisplayed();
  }

  public boolean hasNameError() {
    wait.until(ExpectedConditions.visibilityOf(errorLocator.getNameError()));
    return errorLocator.getNameError().isDisplayed();
  }

  /// 1st TEST DATA APPROACH (most complex) STARTS HERE (invalid_signup_credentials_v1.csv)
  public String getErrorMessage(String fieldName) {
    String errorMessage = "";

    switch (fieldName) {
      case "name" -> errorMessage = getNameErrorText();
      case "email" -> errorMessage = getEmailErrorText();
      case "password" -> errorMessage = getPasswordErrorText();
      case "confirmation" -> errorMessage = getConfirmationErrorText();
      case "country" -> errorMessage = getCountryErrorText();
      case "gender" -> errorMessage = getGenderErrorText();
      case "agreement" -> errorMessage = getAgreementErrorText();
      case "account" -> errorMessage = getExistingAccountErrorText();
    }
    return errorMessage;
  }

  public String getExistingAccountErrorText() {
    wait.until(ExpectedConditions.visibilityOf(errorLocator.getExistingAccountError()));
    return errorLocator.getExistingAccountError().getAttribute("innerText");
  }

  public String getAgreementErrorText() {
    wait.until(ExpectedConditions.visibilityOf(errorLocator.getAgreementError()));
    return errorLocator.getAgreementError().getAttribute("innerText");
  }

  public String getGenderErrorText() {
    wait.until(ExpectedConditions.visibilityOf(errorLocator.getGenderError()));
    return errorLocator.getGenderError().getAttribute("innerText");
  }

  public String getCountryErrorText() {
    wait.until(ExpectedConditions.visibilityOf(errorLocator.getCountryError()));
    return errorLocator.getCountryError().getAttribute("innerText");
  }

  public String getConfirmationErrorText() {
    wait.until(ExpectedConditions.visibilityOf(errorLocator.getConfirmedPasswordError()));
    return errorLocator.getConfirmedPasswordError().getAttribute("innerText");
  }

  public String getPasswordErrorText() {
    wait.until(ExpectedConditions.visibilityOf(errorLocator.getPasswordError()));
    return errorLocator.getPasswordError().getAttribute("innerText");
  }

  public String getEmailErrorText() {
    wait.until(ExpectedConditions.visibilityOf(errorLocator.getEmailError()));
    return errorLocator.getEmailError().getAttribute("innerText");
  }

  public String getNameErrorText() {
    wait.until(ExpectedConditions.visibilityOf(errorLocator.getNameError()));
    return errorLocator.getNameError().getAttribute("innerText");
  }

  public void submit() {
    signUpLocator.getSubmitButton().click();
  }

  public void selectAgreement(String agreement) {
    if (agreement.equals("agree")) clickSelector(signUpLocator.getAgreeSelector());
    else clickSelector(signUpLocator.getRegistrationForm());
  }

  public void selectGender(String gender) {

    if (!gender.isEmpty()) {
      String selector = "input[value='" + gender + "']";
      WebElement selectedElement = signUpLocator.getGenderSelectorRow().findElement(By.cssSelector(selector));
      clickSelector(selectedElement);
    } else {
      clickSelector(signUpLocator.getRegistrationForm());
    }
  }

  public void selectCountry(String countryCode) {

    if (countryCode.equals("Select a country")) {
      clickSelector(signUpLocator.getCountryField());
    } else {
      String selector = "//select[@id='signup-country']/option[@value='" + countryCode + "']";
      WebElement selectedElement = signUpLocator.getCountryField().findElement(By.xpath(selector));

      clickSelector(signUpLocator.getCountryField());
      clickSelector(selectedElement);
    }
  }

  public void clickSelector(WebElement element) {
    wait.until(ExpectedConditions.visibilityOf(element));
    element.click();
  }

  public void enterConfirmedPassword(String password) {
    wait.until(ExpectedConditions.visibilityOf(signUpLocator.getConfirmField()));
    signUpLocator.getConfirmField().sendKeys(password);
  }

  public void enterPassword(String password) {
    wait.until(ExpectedConditions.visibilityOf(signUpLocator.getPasswordField()));
    signUpLocator.getPasswordField().sendKeys(password);
  }

  public void enterEmail(String email) {
    wait.until(ExpectedConditions.visibilityOf(signUpLocator.getEmailField()));
    signUpLocator.getEmailField().sendKeys(email);
  }

  public void enterFullName(String name) {
    wait.until(ExpectedConditions.visibilityOf(signUpLocator.getNameField()));
    signUpLocator.getNameField().sendKeys(name);
  }

  public void clickSignInBtn() {
    wait.until(ExpectedConditions.elementToBeClickable(signUpLocator.getNavToSignInBtn()));
    signUpLocator.getNavToSignInBtn().click();
  }
}
