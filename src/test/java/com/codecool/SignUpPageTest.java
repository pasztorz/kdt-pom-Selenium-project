package com.codecool;

import com.codecool.keywords.HomeKeyword;
import com.codecool.keywords.SignUpKeyword;
import com.codecool.pages.Navbar;
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
  @CsvFileSource(resources = "/testdata/invalid_signup_credentials_v2.csv", numLinesToSkip = 1)
  public void signUpWithErrorsTestV2(String field, String name, String email, String password, String confirmation,
                                           String countryCode, String gender, String agreement) {
    signUpKeyword.openFromLoginPage();
    signUpKeyword.signUp(name, email, password, confirmation, countryCode, gender, agreement);

    Assertions.assertTrue(signUpPage.isErrorDisplayed(field));
    Assertions.assertTrue(signUpPage.isPageOpen("signup"));
  }

  @ParameterizedTest
  @CsvFileSource(resources = "/testdata/invalid_signup_credentials_v1.csv", numLinesToSkip = 1)
  public void signUpWithErrorsTest(String field, String name, String email, String password, String confirmation,
                                           String countryCode, String gender, String agreement, String expected) {
    signUpKeyword.openFromLoginPage();
    signUpKeyword.signUp(name, email, password, confirmation, countryCode, gender, agreement);

    Assertions.assertEquals(expected, signUpPage.getErrorMessage(field));
    Assertions.assertTrue(signUpPage.isPageOpen("signup"));
  }

  @Test
  public void signUpTest() {
    Navbar navbar = new Navbar(driver);

    signUpKeyword.openFromLoginPage();
    signUpKeyword.signUp();

    Assertions.assertTrue(signUpPage.isPageOpen("https://playground.qatools.dev/"));
    Assertions.assertTrue(navbar.isLogoutDisplayed());
    Assertions.assertTrue(navbar.isProfileBtnDisplayed());
  }

  @Test
  public void openFromLoginPageWithCreateButtonTest() {
    signUpKeyword.openFromLoginPage();
    Assertions.assertTrue(signUpPage.isPageOpen("/signup"));
  }

  @AfterEach
  void tearDown() {
    driver.quit();
  }
}
