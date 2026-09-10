package com.codecool;

import com.codecool.keywords.ClinicKeyword;
import com.codecool.keywords.HomeKeyword;
import com.codecool.keywords.LoginKeyword;
import com.codecool.keywords.NavbarKeyword;
import com.codecool.pages.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LogOutTest {
  private WebDriver driver;
  private NavbarKeyword navbarKeyword;
  private ClinicKeyword clinicKeyword;

  @BeforeEach
  void setUp() {
    driver = new ChromeDriver();
    navbarKeyword = new NavbarKeyword(driver);
    clinicKeyword = new ClinicKeyword(driver);

    driver.manage().window().maximize();

    HomeKeyword homeKeyword = new HomeKeyword(driver);
    LoginKeyword loginKeyword = new LoginKeyword(driver);

    homeKeyword.openHome();
    loginKeyword.openFromNavbar();
    loginKeyword.login();
  }

  @Test
  public void closingNoIncognitoBrowserBringsToLoggedOutHomeAfterReopeningTest() {
    driver.close();

    ChromeOptions options = new ChromeOptions();
    options.addArguments("--user-data-dir=/some/test/profile");

    WebDriver newDriver = new ChromeDriver(options);
    HomeKeyword newHomeKeyword = new HomeKeyword(newDriver);
    HomePage newHomePage = new HomePage(newDriver);
    Navbar newNavbar = new Navbar(newDriver);

    newDriver.manage().window().maximize();

    newHomeKeyword.reOpenHomeWithoutIncognito(newDriver);

    Assertions.assertTrue(newNavbar.isLoginDisplayed());
    Assertions.assertTrue(newHomePage.currentUrlEquals());

    newDriver.quit();
  }

  @Test
  public void closingIncognitoBrowserBringsToLoggedOutHomeAfterReopeningTest() {
    driver.close();

    WebDriver newDriver = new ChromeDriver();
    HomeKeyword newHomeKeyword = new HomeKeyword(newDriver);
    HomePage newHomePage = new HomePage(newDriver);
    Navbar newNavbar = new Navbar(newDriver);

    newDriver.manage().window().maximize();

    newHomeKeyword.reOpenHomeWithIncognito(newDriver);

    Assertions.assertTrue(newNavbar.isLoginDisplayed());
    Assertions.assertTrue(newHomePage.currentUrlEquals());

    newDriver.quit();
  }

  @Test
  public void logOutWithButtonTerminatesAccessToAppointmentsOnClinicHomePageTest() {
    ClinicHome clinicHome = new ClinicHome(driver);

    navbarKeyword.logOut();
    clinicKeyword.openClinicFromHomeWithClinicButton();

    Assertions.assertFalse(clinicHome.hasButtonWithText("My appointments"));
  }

  @Test
  public void logOutWithButtonTerminatesAccessToAppointmentsInNavbarTest() {
    ClinicSubNavbar clinicSubNavbar = new ClinicSubNavbar(driver);

    navbarKeyword.logOut();
    clinicKeyword.openClinicFromHomeWithClinicButton();

    Assertions.assertFalse(clinicSubNavbar.hasButtonWithText("My appointments"));
  }

  @Test
  public void logOutWithButtonBringsToLoggedOutHomePageTest() {
    Navbar navbar = new Navbar(driver);
    HomePage homePage = new HomePage(driver);

    navbarKeyword.logOut();

    Assertions.assertTrue(navbar.isLoginDisplayed());
    Assertions.assertTrue(homePage.currentUrlEquals());
  }

  @AfterEach
  void tearDown() {
    driver.quit();
  }
}
