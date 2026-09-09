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

public class LogOutTest {
  private WebDriver driver;
  private Navbar navbar;
  private NavbarKeyword navbarKeyword;

  @BeforeEach
  void setUp() {
    driver = new ChromeDriver();
    navbar = new Navbar(driver);
    navbarKeyword = new NavbarKeyword(driver);

    driver.manage().window().maximize();

    HomeKeyword homeKeyword = new HomeKeyword(driver);
    LoginKeyword loginKeyword = new LoginKeyword(driver);

    homeKeyword.openHome();
    loginKeyword.openFromNavbar();
    loginKeyword.login();
  }

  @Test
  public void logOutWithButtonTerminatesAccessToAppointmentsOnClinicHomeTest() {
    ClinicKeyword clinicKeyword = new ClinicKeyword(driver);
    ClinicHome clinicHome = new ClinicHome(driver);

    navbarKeyword.logOut();
    clinicKeyword.openClinicWithNavButton();

    Assertions.assertFalse(clinicHome.hasButtonWithText("My appointments"));
  }

  @Test
  public void logOutWithButtonTerminatesAccessToAppointmentsInNavbarTest() {
    ClinicKeyword clinicKeyword = new ClinicKeyword(driver);
    ClinicSubNavbar clinicSubNavbar = new ClinicSubNavbar(driver);
    ClinicHome clinicHome = new ClinicHome(driver);

    navbarKeyword.logOut();
    clinicKeyword.openClinicWithNavButton();

    Assertions.assertFalse(clinicSubNavbar.hasButtonWithText("My appointments"));
  }

  @Test
  public void logOutWithButtonTest() {
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
