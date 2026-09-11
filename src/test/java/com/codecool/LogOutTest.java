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
    navbarKeyword = new NavbarKeyword(driver);
    clinicKeyword = new ClinicKeyword(driver);
    browserKeyword = new BrowserKeyword(driver);
    navbar = new Navbar(driver);
    homePage = new HomePage(driver);
    clinicHome = new ClinicHome(driver);
    clinicSubNavbar = new ClinicSubNavbar(driver);

    driver.manage().window().maximize();

    HomeKeyword homeKeyword = new HomeKeyword(driver);
    LoginKeyword loginKeyword = new LoginKeyword(driver);

    homeKeyword.openHomeWithWelcomePopUp();
    loginKeyword.openFromNavbar();
    loginKeyword.login();
  }

  @Test
  public void leavingLoggedInPageInBrowserTerminatesAppointmentsAccessOnClinicHomeTest() {
    browserKeyword.navigateToIndifferentWebPageInBrowser();
    browserKeyword.navigateToIndifferentWebPageInBrowser();
    browserKeyword.navigateBack();
    browserKeyword.navigateBack();

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

    /// ALL BUTTON TEXT assertion bullshit !!!
    /// this assertion would even fail in case of proper functioning - because of time exception !!!
    /// the only working one could be at this stage the navbar `div` and `a` elements' list size comparison !!!
    Assertions.assertFalse(navbar.hasButtonWithText(profileButtonText));
  }

  @Test
  public void closingPersistentBrowserTerminatesAppointmentsAccessOnClinicHomeTest() {
    browserKeyword.closeOpenedBrowser();
    newDriver = browserKeyword.openNewPersistentChrome();

    HomeKeyword newHomeKeyword = new HomeKeyword(newDriver);
    ClinicKeyword newClinicKeyword = new ClinicKeyword(newDriver);
    ClinicHome newClinicHome = new ClinicHome(newDriver);

    newHomeKeyword.openHomeWithoutPopUp();
    newClinicKeyword.openClinicFromHomeWithClinicButton();

    Assertions.assertFalse(newClinicHome.hasButtonWithText(appointmentsButtonText));
  }

  @Test
  public void closingPersistentBrowserTerminatesAppointmentsAccessInNavbarTest() {
    browserKeyword.closeOpenedBrowser();
    newDriver = browserKeyword.openNewPersistentChrome();

    HomeKeyword newHomeKeyword = new HomeKeyword(newDriver);
    ClinicKeyword newClinicKeyword = new ClinicKeyword(newDriver);
    ClinicSubNavbar newClinicSubNavbar = new ClinicSubNavbar(newDriver);

    newHomeKeyword.openHomeWithoutPopUp();
    newClinicKeyword.openClinicFromHomeWithClinicButton();

    Assertions.assertFalse(newClinicSubNavbar.hasButtonWithText(appointmentsButtonText));
  }

  @Test
  public void closingPersistentBrowserBringsToLoggedOutHomeAfterReopeningTest() {
    browserKeyword.closeOpenedBrowser();
    newDriver = browserKeyword.openNewPersistentChrome();

    HomeKeyword newHomeKeyword = new HomeKeyword(newDriver);
    HomePage newHomePage = new HomePage(newDriver);
    Navbar newNavbar = new Navbar(newDriver);

    newHomeKeyword.openHomeWithoutPopUp();

    Assertions.assertTrue(newNavbar.isLoginDisplayed());
    Assertions.assertTrue(newHomePage.currentUrlEquals());
  }

  @Test
  public void closingFreshBrowserTerminatesAppointmentsAccessOnClinicHomeTest() {
    browserKeyword.closeOpenedBrowser();
    newDriver = browserKeyword.openNewFreshChrome();

    HomeKeyword newHomeKeyword = new HomeKeyword(newDriver);
    ClinicKeyword newClinicKeyword = new ClinicKeyword(newDriver);
    ClinicHome newClinicHome = new ClinicHome(newDriver);

    newHomeKeyword.openHomeWithWelcomePopUp();
    newClinicKeyword.openClinicFromHomeWithClinicButton();

    Assertions.assertFalse(newClinicHome.hasButtonWithText(appointmentsButtonText));
  }

  @Test
  public void closingFreshBrowserTerminatesAppointmentsAccessInNavbarTest() {
    browserKeyword.closeOpenedBrowser();
    newDriver = browserKeyword.openNewFreshChrome();

    HomeKeyword newHomeKeyword = new HomeKeyword(newDriver);
    ClinicKeyword newClinicKeyword = new ClinicKeyword(newDriver);
    ClinicSubNavbar newClinicSubNavbar = new ClinicSubNavbar(newDriver);

    newHomeKeyword.openHomeWithWelcomePopUp();
    newClinicKeyword.openClinicFromHomeWithClinicButton();

    Assertions.assertFalse(newClinicSubNavbar.hasButtonWithText(appointmentsButtonText));
  }

  @Test
  public void closingFreshBrowserBringsToLoggedOutHomeAfterReopeningTest() {
    browserKeyword.closeOpenedBrowser();
    newDriver = browserKeyword.openNewFreshChrome();

    HomeKeyword newHomeKeyword = new HomeKeyword(newDriver);
    HomePage newHomePage = new HomePage(newDriver);
    Navbar newNavbar = new Navbar(newDriver);

    newHomeKeyword.openHomeWithWelcomePopUp();

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
