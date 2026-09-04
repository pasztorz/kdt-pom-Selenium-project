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
