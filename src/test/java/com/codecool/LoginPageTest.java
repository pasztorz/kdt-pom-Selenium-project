package com.codecool;

import com.codecool.keywords.HomeKeyword;
import com.codecool.keywords.LoginKeyword;
import com.codecool.pages.HomePage;
import com.codecool.pages.LoginPage;
import com.codecool.pages.Navbar;
import io.github.cdimascio.dotenv.Dotenv;
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
  @CsvFileSource(resources = "/testdata/invalid_login_credentials.csv", numLinesToSkip = 1)
  public void loginWithInvalidCredentialTest(String parameter, String email, String password, String expected) {
    loginKeyword.openFromNavbar();
    loginKeyword.login(email, password);

    Assertions.assertEquals(expected, loginKeyword.getErrorMessage(parameter));
    Assertions.assertTrue(loginPage.isPageOpen("login"));
  }

  @Test
  public void loginTest() {
    Dotenv dotenv = Dotenv.load();
    String email = dotenv.get("DEFAULT_TEST_USER_EMAIL");
    String password = dotenv.get("DEFAULT_TEST_USER_PASSWORD");

    loginKeyword.openFromNavbar();
    loginKeyword.login(email, password);

    Navbar navbar = new Navbar(driver);
    HomePage homePage = new HomePage(driver);
    Assertions.assertTrue(navbar.isLogoutDisplayed());
    Assertions.assertTrue(homePage.isPageOpen("https://playground.qatools.dev"));
  }

  @Test
  public void openWithSignUpPageSignInBtnTest() {
    loginKeyword.openFromSignUpPage();
    Assertions.assertTrue(loginPage.isPageOpen("login"));
  }

  @Test
  public void openWithNavbarButtonTest() {
    loginKeyword.openFromNavbar();
    Assertions.assertTrue(loginPage.isPageOpen("login"));
  }

  @AfterEach
  void tearDown() {
    driver.quit();
  }
}
