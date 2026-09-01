package com.codecool.keywords;

import com.codecool.pages.LoginPage;
import com.codecool.pages.SignUpPage;
import com.codecool.service.ValidCountryProvider;
import com.codecool.service.CredentialsProvider;
import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.WebDriver;

public class SignUpKeyword {
  private static final Dotenv DOTENV = Dotenv.load();
  private static final String FIRST_NAME = DOTENV.get("DEFAULT_NEW_TEST_USER_FIRSTNAME");
  private static final String LAST_NAME = DOTENV.get("DEFAULT_NEW_TEST_USER_LASTNAME");

  private final LoginPage loginPage;
  private final SignUpPage signUpPage;
  private final CredentialsProvider credentialsProvider = new CredentialsProvider(FIRST_NAME, LAST_NAME);
  private final ValidCountryProvider validCountryProvider = new ValidCountryProvider();

  public SignUpKeyword(WebDriver driver) {
    this.loginPage = new LoginPage(driver);
    this.signUpPage = new SignUpPage(driver);
  }

  public void signUp() {
    String optionValue = validCountryProvider.getRandomCountry();

    completeInputFields();
    completeSelectorFields(optionValue);
  }

  public void completeSelectorFields(String optionValue) {
    signUpPage.selectCountry(optionValue);

  }

  public void completeInputFields() {
    String fullName = credentialsProvider.createTestFullName();
    String email = credentialsProvider.createTestEmail();
    String password = credentialsProvider.createTestPassword();

    signUpPage.enterFullName(fullName);
    signUpPage.enterEmail(email);
    signUpPage.enterPassword(password);
    signUpPage.enterConfirmedPassword(password);
  }

  public void openFromLoginPage() {
    loginPage.openPage();
    loginPage.clickCreateBtn();
  }
}
