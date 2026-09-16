package com.codecool;

import com.codecool.keywords.*;
import com.codecool.model.ButtonType;
import com.codecool.pages.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogOutTest {
  private WebDriver driver;
  private WebDriver newDriver;
  private HomeKeyword homeKeyword;
  private NavbarKeyword navbarKeyword;
  private ClinicKeyword clinicKeyword;
  private BrowserKeyword browserKeyword;
  private HomePage homePage;
  private Navbar navbar;
  private ClinicHome clinicHome;
  private ClinicSubNavbar clinicSubNavbar;

  private final String appointmentsButtonText = ButtonType.APPOINTMENTS.getText();

  @BeforeEach
  void setUp() {
    driver = new ChromeDriver();
    navbar = new Navbar(driver);
    homePage = new HomePage(driver);
    clinicHome = new ClinicHome(driver);
    clinicSubNavbar = new ClinicSubNavbar(driver);
    homeKeyword = new HomeKeyword(driver);
    navbarKeyword = new NavbarKeyword(driver);
    clinicKeyword = new ClinicKeyword(driver);
    browserKeyword = new BrowserKeyword(driver);

    driver.manage().window().maximize();

    LoginKeyword loginKeyword = new LoginKeyword(driver);

    homeKeyword.openHomeAndSkipPopUp();
    loginKeyword.openFromNavbar();
    loginKeyword.login();
  }

  @Test
  public void leavingLoggedInPageInBrowserTerminatesAppointmentsAccessOnClinicHomeTest() {
    browserKeyword.navigateToIndifferentWebPageInBrowser();
    browserKeyword.navigateToIndifferentWebPageInBrowser();
    browserKeyword.navigateBack();
    browserKeyword.navigateBack();

    clinicKeyword.openClinicFromHomeWithClinicButton();

    Assertions.assertFalse(clinicHome.hasButtonWithText(appointmentsButtonText));
  }

  @Test
  public void leavingLoggedInPageInBrowserTerminatesAppointmentsAccessInNavbarTest() {
    browserKeyword.navigateToIndifferentWebPageInBrowser();
    browserKeyword.navigateToIndifferentWebPageInBrowser();
    browserKeyword.navigateBack();
    browserKeyword.navigateBack();

    clinicKeyword.openClinicFromHomeWithClinicButton();

    Assertions.assertFalse(clinicSubNavbar.hasButtonWithText(appointmentsButtonText));
  }

  @Test
  public void leavingLoggedInPageInBrowserBringsBackToLoggedOutHomeAfterReturningTest() {
    String profileButtonText = navbar.getProfileButtonText();

    browserKeyword.navigateToIndifferentWebPageInBrowser();
    browserKeyword.navigateToIndifferentWebPageInBrowser();
    browserKeyword.navigateBack();
    browserKeyword.navigateBack();

    Assertions.assertFalse(navbar.hasButtonWithText(profileButtonText));
  }

  @Test
  public void closingPersistentBrowserTerminatesAppointmentsAccessOnClinicHomeTest() {
    browserKeyword.closeBrowser();

    newDriver = browserKeyword.openPersistentChrome();
    ClinicHome newClinicHome = new ClinicHome(newDriver);

    homeKeyword.openNewHomeWithoutPopUp(newDriver);
    clinicKeyword.openClinicFromNewHome(newDriver);

    Assertions.assertFalse(newClinicHome.hasButtonWithText(appointmentsButtonText));
  }

  @Test
  public void closingPersistentBrowserTerminatesAppointmentsAccessInNavbarTest() {
    browserKeyword.closeBrowser();

    newDriver = browserKeyword.openPersistentChrome();
    ClinicSubNavbar newClinicSubNavbar = new ClinicSubNavbar(newDriver);

    homeKeyword.openNewHomeWithoutPopUp(newDriver);
    clinicKeyword.openClinicFromNewHome(newDriver);

    Assertions.assertFalse(newClinicSubNavbar.hasButtonWithText(appointmentsButtonText));
  }

  @Test
  public void closingPersistentBrowserBringsToLoggedOutHomeAfterReopeningTest() {
    browserKeyword.closeBrowser();

    newDriver = browserKeyword.openPersistentChrome();
    HomePage newHomePage = new HomePage(newDriver);
    Navbar newNavbar = new Navbar(newDriver);

    homeKeyword.openNewHomeWithoutPopUp(newDriver);

    Assertions.assertTrue(newNavbar.isLoginDisplayed());
    Assertions.assertTrue(newHomePage.currentUrlEquals());
  }

  @Test
  public void closingFreshBrowserTerminatesAppointmentsAccessOnClinicHomeTest() {
    browserKeyword.closeBrowser();

    newDriver = browserKeyword.openFreshChrome();
    ClinicHome newClinicHome = new ClinicHome(newDriver);

    homeKeyword.openNewHomeWithPopUp(newDriver);
    clinicKeyword.openClinicFromNewHome(newDriver);

    Assertions.assertFalse(newClinicHome.hasButtonWithText(appointmentsButtonText));
  }

  @Test
  public void closingFreshBrowserTerminatesAppointmentsAccessInNavbarTest() {
    browserKeyword.closeBrowser();

    newDriver = browserKeyword.openFreshChrome();
    ClinicSubNavbar newClinicSubNavbar = new ClinicSubNavbar(newDriver);

    homeKeyword.openNewHomeWithPopUp(newDriver);
    clinicKeyword.openClinicFromNewHome(newDriver);

    Assertions.assertFalse(newClinicSubNavbar.hasButtonWithText(appointmentsButtonText));
  }

  @Test
  public void closingFreshBrowserBringsToLoggedOutHomeAfterReopeningTest() {
    browserKeyword.closeBrowser();

    newDriver = browserKeyword.openFreshChrome();
    HomePage newHomePage = new HomePage(newDriver);
    Navbar newNavbar = new Navbar(newDriver);

    homeKeyword.openNewHomeWithPopUp(newDriver);

    Assertions.assertTrue(newNavbar.isLoginDisplayed());
    Assertions.assertTrue(newHomePage.currentUrlEquals());
  }

  @Test
  public void logOutWithButtonTerminatesAppointmentsAccessOnClinicHomeTest() {
    navbarKeyword.logOut();
    clinicKeyword.openClinicFromHomeWithClinicButton();

    Assertions.assertFalse(clinicHome.hasButtonWithText(appointmentsButtonText));
  }

  @Test
  public void logOutWithButtonTerminatesAppointmentsAccessInNavbarTest() {
    navbarKeyword.logOut();
    clinicKeyword.openClinicFromHomeWithClinicButton();

    Assertions.assertFalse(clinicSubNavbar.hasButtonWithText(appointmentsButtonText));
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
