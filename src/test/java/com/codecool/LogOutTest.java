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
  private BrowserKeyword browserKeyword;
  private HomePage homePage;
  private Navbar navbar;

  @BeforeEach
  void setUp() {
    driver = new ChromeDriver();
    navbarKeyword = new NavbarKeyword(driver);
    clinicKeyword = new ClinicKeyword(driver);
    browserKeyword = new BrowserKeyword(driver);
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
    String buttonText = navbar.getProfileButtonText();

    browserKeyword.navigateToIndifferentWebPageInBrowser();
    browserKeyword.navigateToIndifferentWebPageInBrowser();
    browserKeyword.navigateBack();
    browserKeyword.navigateBack();

    Assertions.assertTrue(homePage.currentUrlEquals());
    Assertions.assertFalse(navbar.hasButtonWithText(buttonText));
  }

  @Test
  public void closingNoIncognitoBrowserTerminatesAccessToAppointmentsOnClinicHomeTest() {
    newDriver = browserKeyword.createPersistentChromeSession();

    HomeKeyword newHomeKeyword = new HomeKeyword(newDriver);
    ClinicKeyword newClinicKeyword = new ClinicKeyword(newDriver);
    ClinicHome newClinicHome = new ClinicHome(newDriver);

    newHomeKeyword.openHomeWithoutPopUp();
    newClinicKeyword.openClinicFromHomeWithClinicButton();

    Assertions.assertFalse(newClinicHome.hasButtonWithText("My appointments"));
  }

  @Test
  public void closingNoIncognitoBrowserTerminatesAccessToAppointmentsInNavbarTest() {
    newDriver = browserKeyword.createPersistentChromeSession();

    HomeKeyword newHomeKeyword = new HomeKeyword(newDriver);
    ClinicKeyword newClinicKeyword = new ClinicKeyword(newDriver);
    ClinicSubNavbar newClinicSubNavbar = new ClinicSubNavbar(newDriver);

    newHomeKeyword.openHomeWithoutPopUp();
    newClinicKeyword.openClinicFromHomeWithClinicButton();

    Assertions.assertFalse(newClinicSubNavbar.hasButtonWithText("My appointments"));
  }

  @Test
  public void closingNoIncognitoBrowserBringsToLoggedOutHomeAfterReopeningTest() {
    newDriver = browserKeyword.createPersistentChromeSession();

    HomeKeyword newHomeKeyword = new HomeKeyword(newDriver);
    HomePage newHomePage = new HomePage(newDriver);
    Navbar newNavbar = new Navbar(newDriver);

    newHomeKeyword.openHomeWithoutPopUp();

    Assertions.assertTrue(newNavbar.isLoginDisplayed());
    Assertions.assertTrue(newHomePage.currentUrlEquals());
  }

  @Test
  public void closingIncognitoBrowserTerminatesAccessToAppointmentsOnClinicHomeTest() {
    newDriver = browserKeyword.createFreshChromeSession();

    HomeKeyword newHomeKeyword = new HomeKeyword(newDriver);
    ClinicKeyword newClinicKeyword = new ClinicKeyword(newDriver);
    ClinicHome newClinicHome = new ClinicHome(newDriver);

    newHomeKeyword.openHomeWithWelcomePopUp();
    newClinicKeyword.openClinicFromHomeWithClinicButton();

    Assertions.assertFalse(newClinicHome.hasButtonWithText("My appointments"));
  }

  @Test
  public void closingIncognitoBrowserTerminatesAccessToAppointmentsInNavbarTest() {
    newDriver = browserKeyword.createFreshChromeSession();

    HomeKeyword newHomeKeyword = new HomeKeyword(newDriver);
    ClinicKeyword newClinicKeyword = new ClinicKeyword(newDriver);
    ClinicSubNavbar newClinicSubNavbar = new ClinicSubNavbar(newDriver);

    newHomeKeyword.openHomeWithWelcomePopUp();
    newClinicKeyword.openClinicFromHomeWithClinicButton();

    Assertions.assertFalse(newClinicSubNavbar.hasButtonWithText("My appointments"));
  }

  @Test
  public void closingIncognitoBrowserBringsToLoggedOutHomeAfterReopeningTest() {
    newDriver = browserKeyword.createFreshChromeSession();

    HomeKeyword newHomeKeyword = new HomeKeyword(newDriver);
    HomePage newHomePage = new HomePage(newDriver);
    Navbar newNavbar = new Navbar(newDriver);

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
