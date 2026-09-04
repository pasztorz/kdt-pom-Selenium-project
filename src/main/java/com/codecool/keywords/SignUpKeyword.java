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

  /// 3rd TEST DATA APPROACH
  public void signUp(String fieldName, String input, String confirmation) {
    signUpPage.enterInput(fieldName, input, confirmation);
    signUpPage.submit();
  }

  /// ORIGINAL TEST DATA APPROACH
  public void signUp(String name, String email, String password, String confirmedPass,
                     String countryCode, String gender, String agreement) {
    signUpPage.enterFullName(name);
    signUpPage.enterEmail(email);
    signUpPage.enterPassword(password);
    signUpPage.enterConfirmedPassword(confirmedPass);
    signUpPage.selectCountry(countryCode);
    signUpPage.selectGender(gender);
    signUpPage.selectAgreement(agreement);
    signUpPage.submit();
  }

  public void signUp() {
    String name = credentialsProvider.createTestName();
    String email = credentialsProvider.createTestEmail();
    String password = credentialsProvider.createTestPassword();
    String countryCode = countryProvider.getRandomCountry();
    String gender = genderProvider.getRandomGender();
    String agreement = "agree";

    signUp(name, email, password, password, countryCode, gender, agreement);
  }

  public void openFromLoginPage() {
    loginPage.openPage();
    loginPage.clickCreateBtn();
  }
}
