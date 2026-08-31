package com.codecool;

import com.codecool.keywords.HomeKeyword;
import com.codecool.keywords.LoginKeyword;
import com.codecool.pages.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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

  @Test
  public void openWithNavbarButtonTest() {
    loginKeyword.openFromNavbar();

    Assertions.assertTrue(loginPage.isPageOpen("login"));
  }

  @Test
  public void openWithSignUpPageSignInBtnTest() {
    loginKeyword.openFromSignUpPage();

    Assertions.assertTrue(loginPage.isPageOpen("login"));
  }

  @AfterEach
  void tearDown() {
    driver.quit();
  }
}
