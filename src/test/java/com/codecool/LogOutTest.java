package com.codecool;

import com.codecool.keywords.HomeKeyword;
import com.codecool.keywords.LoginKeyword;
import com.codecool.keywords.NavbarKeyword;
import com.codecool.pages.ClinicHome;
import com.codecool.pages.HomePage;
import com.codecool.pages.Navbar;
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
  public void logOutWithButtonTerminatesAccessToAppointmentsTest() {
    ClinicKeyword clinicKeyword = new ClinicKeyword(driver);
    ClinicSubNavbar clinicSubNavbar = new ClinicSubNavbar(driver);

    navbarKeyword.logOut();
    clinicKeyword.openClinic();

    Assertions.assertTrue(clinicSubNavbar.appointmentsUnavailable());
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
