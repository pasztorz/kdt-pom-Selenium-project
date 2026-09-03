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

  protected SignUpLocator signUpLocator;
  private final WebDriverWait wait;

  public SignUpPage(WebDriver driver) {
    super(driver, URL);
    this.signUpLocator = new SignUpLocator(driver);
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
    String selector = "//select[@id='signup-country']/option[@value='" + countryCode + "']";
    WebElement selectedElement = signUpLocator.getCountryField().findElement(By.xpath(selector));

    clickSelector(signUpLocator.getCountryField());
    clickSelector(selectedElement);
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

  public void enterFullName(String fullName) {
    wait.until(ExpectedConditions.visibilityOf(signUpLocator.getNameField()));
    signUpLocator.getNameField().sendKeys(fullName);
  }

  public void clickSignInBtn() {
    wait.until(ExpectedConditions.elementToBeClickable(signUpLocator.getNavToSignInBtn()));
    signUpLocator.getNavToSignInBtn().click();
  }
}
