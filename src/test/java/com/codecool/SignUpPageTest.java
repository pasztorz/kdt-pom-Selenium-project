package com.codecool;

import com.codecool.keywords.HomeKeyword;
import com.codecool.keywords.ProfileKeyword;
import com.codecool.keywords.SignUpKeyword;
import com.codecool.pages.HomePage;
import com.codecool.pages.Navbar;
import com.codecool.pages.ProfilePage;
import com.codecool.pages.SignUpPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignUpPageTest {
  private WebDriver driver;
  private SignUpPage signUpPage;
  private Navbar navbar;
  private SignUpKeyword signUpKeyword;

  private String generatedPassword;

  @BeforeEach
  void setUp() {
    driver = new ChromeDriver();
    signUpPage = new SignUpPage(driver);
    navbar = new Navbar(driver);
    signUpKeyword = new SignUpKeyword(driver);
    HomeKeyword homeKeyword = new HomeKeyword(driver);

    generatedPassword = signUpKeyword.getUniquePassword();

    driver.manage().window().maximize();

    homeKeyword.openHomeAndSkipPopUp();
  }

  @ParameterizedTest
  @CsvFileSource(resources = "/testdata/invalid_signup_credentials.csv", numLinesToSkip = 1)
  public void signUpFailsWithWrongAndMissingFieldsTest(String field, String name, String email, String paramPassword, String confirmation,
                                           String countryCode, String gender, String agreement, String expected) {
    signUpKeyword.openFromLoginPage();
    signUpKeyword.signUp(name, email, paramPassword, confirmation, countryCode, gender, agreement);

    Assertions.assertEquals(expected, signUpPage.getErrorMessage(field));
    Assertions.assertTrue(signUpPage.currentUrlContains("signup"));
  }

  @Test
  public void passwordInputFieldsHavePasswordTypeTest() {
    String expected = "password";

    signUpKeyword.openFromLoginPage();

    Assertions.assertEquals(expected, signUpPage.getPasswordInputType());
    Assertions.assertEquals(expected, signUpPage.getConfirmedPasswordInputType());
  }

  @Test
  public void passwordIsNotExposedInNavigationButtonsAfterSignUpTest() {
    signUpKeyword.openFromLoginPage();
    signUpKeyword.signUp(generatedPassword);

    Assertions.assertFalse(navbar.profileButtonContains(generatedPassword));
    Assertions.assertFalse(navbar.logOutButtonContains(generatedPassword));
  }

  @Test
  public void passwordIsNotExposedInProfileAfterSignUpTest() {
    ProfilePage profilePage = new ProfilePage(driver);
    ProfileKeyword profileKeyword = new ProfileKeyword(driver);

    signUpKeyword.openFromLoginPage();
    signUpKeyword.signUp(generatedPassword);

    profileKeyword.openProfileForm();

    Assertions.assertFalse(profilePage.profilePageContains(generatedPassword));
  }

  @Test
  public void passwordIsNotExposedInUrlAfterSignUpTest() {
    signUpKeyword.openFromLoginPage();
    signUpKeyword.signUp(generatedPassword);

    Assertions.assertFalse(signUpPage.currentUrlContains(generatedPassword));
  }

  @Test
  public void signUpWithValidFieldContentTest() {
    HomePage homePage = new HomePage(driver);

    signUpKeyword.openFromLoginPage();
    signUpKeyword.signUp();

    Assertions.assertTrue(navbar.isLogOutDisplayed());
    Assertions.assertTrue(navbar.isProfileBtnDisplayed());
    Assertions.assertTrue(homePage.currentUrlEquals());
  }

  @Test
  public void openFromLoginPageWithCreateButtonTest() {
    signUpKeyword.openFromLoginPage();
    Assertions.assertTrue(signUpPage.currentUrlContains("/signup"));
  }

  @AfterEach
  void tearDown() {
    driver.quit();
  }
}
