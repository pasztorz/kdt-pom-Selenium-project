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
  private SignUpKeyword signUpKeyword;

  @BeforeEach
  void setUp() {
    driver = new ChromeDriver();
    signUpPage = new SignUpPage(driver);
    signUpKeyword = new SignUpKeyword(driver);

    driver.manage().window().maximize();

    HomeKeyword homeKeyword = new HomeKeyword(driver);
    homeKeyword.openHome();
  }

  @ParameterizedTest
  @CsvFileSource(resources = "/testdata/invalid_signup_credentials.csv", numLinesToSkip = 1)
  public void signUpFailsWithWrongAndMissingFieldsTest(String field, String name, String email, String password, String confirmation,
                                           String countryCode, String gender, String agreement, String expected) {
    signUpKeyword.openFromLoginPage();
    signUpKeyword.signUp(name, email, password, confirmation, countryCode, gender, agreement);

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
    Navbar navbar = new Navbar(driver);
    String password = signUpKeyword.getUniquePassword();

    signUpKeyword.openFromLoginPage();
    signUpKeyword.signUp(password);

    Assertions.assertFalse(navbar.profileButtonContains(password));
    Assertions.assertFalse(navbar.logOutButtonContains(password));
  }

  @Test
  public void passwordIsNotExposedInProfileAfterSignUpTest() {
    ProfilePage profilePage = new ProfilePage(driver);
    ProfileKeyword profileKeyword = new ProfileKeyword(driver);
    String password = signUpKeyword.getUniquePassword();

    signUpKeyword.openFromLoginPage();
    signUpKeyword.signUp(password);

    profileKeyword.openProfileForm();

    Assertions.assertFalse(profilePage.profilePageContains(password));
  }

  @Test
  public void passwordIsNotExposedInUrlAfterSignUpTest() {
    String password = signUpKeyword.getUniquePassword();

    signUpKeyword.openFromLoginPage();
    signUpKeyword.signUp(password);

    Assertions.assertFalse(signUpPage.currentUrlContains(password));
  }

  @Test
  public void signUpWithValidFieldContentTest() {
    HomePage homePage = new HomePage(driver);
    Navbar navbar = new Navbar(driver);

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
