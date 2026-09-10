package com.codecool;

import com.codecool.keywords.*;
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
  private WebDriver newDriver;
  private NavbarKeyword navbarKeyword;
  private ClinicKeyword clinicKeyword;
  private HomePage homePage;
  private Navbar navbar;

  @BeforeEach
  void setUp() {
    driver = new ChromeDriver();
    navbarKeyword = new NavbarKeyword(driver);
    clinicKeyword = new ClinicKeyword(driver);
    navbar = new Navbar(driver);
    homePage = new HomePage(driver);

    driver.manage().window().maximize();

    HomeKeyword homeKeyword = new HomeKeyword(driver);
    LoginKeyword loginKeyword = new LoginKeyword(driver);

    homeKeyword.openHomeWithWelcomePopUp();
    loginKeyword.openFromNavbar();
    loginKeyword.login();
  }

  @Test
  public void leavingLoggedInPageInBrowserBringsBackToLoggedOutHomeAfterReturningTest() {
    BrowserKeyword browserKeyword = new BrowserKeyword(driver);
    String buttonText = navbar.getProfileButtonText();

    browserKeyword.navigateToIndifferentWebPagesInBrowser();
    browserKeyword.navigateToIndifferentWebPagesInBrowser();
    browserKeyword.navigateBack();
    browserKeyword.navigateBack();

    Assertions.assertTrue(homePage.currentUrlEquals());
    Assertions.assertFalse(navbar.hasButtonWithText(buttonText));
  }

  @Test
  public void closingNoIncognitoBrowserTerminatesAccessToAppointmentsOnClinicHomeTest() {
    driver.close();

    ChromeOptions options = new ChromeOptions();
    options.addArguments("--user-data-dir=/some/test/profile");

    newDriver = new ChromeDriver(options);
    HomeKeyword newHomeKeyword = new HomeKeyword(newDriver);
    ClinicKeyword newClinicKeyword = new ClinicKeyword(newDriver);
    ClinicHome newClinicHome = new ClinicHome(newDriver);

    newDriver.manage().window().maximize();

    newHomeKeyword.openHomeWithoutPopUp();
    newClinicKeyword.openClinicFromHomeWithClinicButton();

    Assertions.assertFalse(newClinicHome.hasButtonWithText("My appointments"));
  }

  @Test
  public void closingNoIncognitoBrowserTerminatesAccessToAppointmentsInNavbarTest() {
    driver.close();

    ChromeOptions options = new ChromeOptions();
    options.addArguments("--user-data-dir=/some/test/profile");

    newDriver = new ChromeDriver(options);
    HomeKeyword newHomeKeyword = new HomeKeyword(newDriver);
    ClinicKeyword newClinicKeyword = new ClinicKeyword(newDriver);
    ClinicSubNavbar newClinicSubNavbar = new ClinicSubNavbar(newDriver);

    newDriver.manage().window().maximize();

    newHomeKeyword.openHomeWithoutPopUp();
    newClinicKeyword.openClinicFromHomeWithClinicButton();

    Assertions.assertFalse(newClinicSubNavbar.hasButtonWithText("My appointments"));
  }

  @Test
  public void closingNoIncognitoBrowserBringsToLoggedOutHomeAfterReopeningTest() {
    driver.close();

    ChromeOptions options = new ChromeOptions();
    options.addArguments("--user-data-dir=/some/test/profile");

    newDriver = new ChromeDriver(options);
    HomeKeyword newHomeKeyword = new HomeKeyword(newDriver);
    HomePage newHomePage = new HomePage(newDriver);
    Navbar newNavbar = new Navbar(newDriver);

    newDriver.manage().window().maximize();

    newHomeKeyword.openHomeWithoutPopUp();

    Assertions.assertTrue(newNavbar.isLoginDisplayed());
    Assertions.assertTrue(newHomePage.currentUrlEquals());
  }

  @Test
  public void closingIncognitoBrowserTerminatesAccessToAppointmentsOnClinicHomeTest() {
    driver.close();

    newDriver = new ChromeDriver();
    HomeKeyword newHomeKeyword = new HomeKeyword(newDriver);
    ClinicKeyword newClinicKeyword = new ClinicKeyword(newDriver);
    ClinicHome newClinicHome = new ClinicHome(newDriver);

    newDriver.manage().window().maximize();

    newHomeKeyword.openHomeWithWelcomePopUp();
    newClinicKeyword.openClinicFromHomeWithClinicButton();

    Assertions.assertFalse(newClinicHome.hasButtonWithText("My appointments"));
  }

  @Test
  public void closingIncognitoBrowserTerminatesAccessToAppointmentsInNavbarTest() {
    driver.close();

    newDriver = new ChromeDriver();
    HomeKeyword newHomeKeyword = new HomeKeyword(newDriver);
    ClinicKeyword newClinicKeyword = new ClinicKeyword(newDriver);
    ClinicSubNavbar newClinicSubNavbar = new ClinicSubNavbar(newDriver);

    newDriver.manage().window().maximize();

    newHomeKeyword.openHomeWithWelcomePopUp();
    newClinicKeyword.openClinicFromHomeWithClinicButton();

    Assertions.assertFalse(newClinicSubNavbar.hasButtonWithText("My appointments"));
  }

  @Test
  public void closingIncognitoBrowserBringsToLoggedOutHomeAfterReopeningTest() {
    driver.close();

    newDriver = new ChromeDriver();
    HomeKeyword newHomeKeyword = new HomeKeyword(newDriver);
    HomePage newHomePage = new HomePage(newDriver);
    Navbar newNavbar = new Navbar(newDriver);

    newDriver.manage().window().maximize();

    newHomeKeyword.openHomeWithWelcomePopUp();

    Assertions.assertTrue(newNavbar.isLoginDisplayed());
    Assertions.assertTrue(newHomePage.currentUrlEquals());
  }

  @Test
  public void logOutWithButtonTerminatesAccessToAppointmentsOnClinicHomeTest() {
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
    navbarKeyword.logOut();

    Assertions.assertTrue(navbar.isLoginDisplayed());
    Assertions.assertTrue(homePage.currentUrlEquals());
  }

  @AfterEach
  void tearDown() {
    driver.quit();

    if (newDriver != null) newDriver.quit();
  }
}
