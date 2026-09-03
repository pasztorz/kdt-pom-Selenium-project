package com.codecool.keywords;

import com.codecool.pages.LoginPage;
import com.codecool.pages.SignUpPage;
import com.codecool.service.GenderProvider;
import com.codecool.service.CountryProvider;
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
  private final CountryProvider countryProvider = new CountryProvider();
  private final GenderProvider genderProvider = new GenderProvider();

  public SignUpKeyword(WebDriver driver) {
    this.loginPage = new LoginPage(driver);
    this.signUpPage = new SignUpPage(driver);
  }

  public void signUp() {
    String countryCode = countryProvider.getRandomCountry();
    String gender = genderProvider.getRandomGender();

    completeInputFields();
    completeSelectorFields(countryCode, gender);
    signUpPage.submit();
  }

  public void completeSelectorFields(String countryCode, String gender) {
    signUpPage.selectCountry(countryCode);
    signUpPage.selectGender(gender);
    signUpPage.selectAgreement();
  }

  public void completeInputFields() {
    String fullName = credentialsProvider.createTestName();
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
