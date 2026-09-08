package com.codecool;

import com.codecool.keywords.HomeKeyword;
import com.codecool.keywords.LoginKeyword;
import com.codecool.keywords.ProfileKeyword;
import com.codecool.pages.HomePage;
import com.codecool.pages.LoginPage;
import com.codecool.pages.Navbar;
import com.codecool.pages.ProfilePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPageTest {
  private WebDriver driver;
  private LoginPage loginPage;
  private LoginKeyword loginKeyword;

  @BeforeEach
  void setUp() {
    driver = new ChromeDriver();
    loginPage = new LoginPage(driver);
    loginKeyword = new LoginKeyword(driver);

    driver.manage().window().maximize();

    HomeKeyword homeKeyword = new HomeKeyword(driver);
    homeKeyword.openHome();
  }

  @ParameterizedTest
  @CsvFileSource(resources = "/testdata/invalid_logins_for_password_exposure_in_errors.csv", numLinesToSkip = 1)
  public void passwordIsNotExposedInErrorMessagesTest(String field, String invalidPassword) {
    String validPassword = LoginKeyword.getPASSWORD();

    loginKeyword.openFromNavbar();
    loginKeyword.login(invalidPassword);

    Assertions.assertFalse(loginPage.errorMessageFieldContainsPassword(field, validPassword));
  }

  @ParameterizedTest
  @CsvFileSource(resources = "/testdata/invalid_login_credentials.csv", numLinesToSkip = 1)
  public void loginFailsWithWrongAndMissingFieldsTest(String field, String email, String password, String expected) {
    loginKeyword.openFromNavbar();
    loginKeyword.login(email, password);

    Assertions.assertEquals(expected, loginPage.getErrorMessage(field));
    Assertions.assertTrue(loginPage.currentUrlContains("login"));
  }

  @Test
  public void passwordInputFieldHasPasswordTypeTest() {
    loginKeyword.openFromNavbar();

    Assertions.assertEquals("password", loginPage.getPasswordInputType());
  }

  @Test
  public void passwordIsNotExposedInProfileAfterLoginTesT() {
    ProfilePage profilePage = new ProfilePage(driver);
    ProfileKeyword profileKeyword = new ProfileKeyword(driver);
    String password = LoginKeyword.getPASSWORD();

    loginKeyword.openFromNavbar();
    loginKeyword.login(password);
    profileKeyword.openProfileForm();

    Assertions.assertFalse(profilePage.profilePageContains(password));
  }

  @Test
  public void passwordIsNotExposedInProfileButtonAfterLoginTest() {
    Navbar navbar = new Navbar(driver);
    String password = LoginKeyword.getPASSWORD();

    loginKeyword.openFromNavbar();
    loginKeyword.login(password);

    Assertions.assertFalse(navbar.profileButtonContains(password));
  }

  @Test
  public void passwordIsNotExposedInUrlAfterLoginTest() {
    HomePage homePage = new HomePage(driver);
    String password = LoginKeyword.getPASSWORD();

    loginKeyword.openFromNavbar();
    loginKeyword.login(password);

    Assertions.assertFalse(homePage.currentUrlContains(password));
  }

  @Test
  public void loginWithValidFieldsContentTest() {
    Navbar navbar = new Navbar(driver);
    HomePage homePage = new HomePage(driver);

    loginKeyword.openFromNavbar();
    loginKeyword.login();

    Assertions.assertTrue(navbar.isLogoutDisplayed());
    Assertions.assertTrue(navbar.isProfileBtnDisplayed());
    Assertions.assertTrue(homePage.currentUrlEquals("https://playground.qatools.dev/"));
  }

  @Test
  public void openWithSignUpPageSignInBtnTest() {
    loginKeyword.openFromSignUpPage();
    Assertions.assertTrue(loginPage.currentUrlContains("login"));
  }

  @Test
  public void openWithNavbarButtonTest() {
    loginKeyword.openFromNavbar();
    Assertions.assertTrue(loginPage.currentUrlContains("login"));
  }

  @AfterEach
  void tearDown() {
    driver.quit();
  }
}
