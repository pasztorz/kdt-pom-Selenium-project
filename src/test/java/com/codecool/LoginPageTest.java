package com.codecool;

import com.codecool.keywords.HomeKeyword;
import com.codecool.keywords.LoginKeyword;
import com.codecool.keywords.SignUpKeyword;
import com.codecool.pages.LoginPage;
import com.codecool.pages.SignUpPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPageTest {
  private WebDriver driver;
  private LoginPage loginPage;
  private LoginKeyword login;

  @BeforeEach
  void setUp() {
    driver = new ChromeDriver();
    loginPage = new LoginPage(driver);
    login = new LoginKeyword(driver);

    driver.manage().window().maximize();

    HomeKeyword homeKeyword = new HomeKeyword(driver);
    homeKeyword.open();
  }

  @Test
  public void openWithNavbarButtonTest() {
    login.clickNavbarSignInBtn();

    Assertions.assertTrue(loginPage.isPageOpen("login"));
  }

  @Test
  public void openWithSignUpPageSignInBtnTest() {
    SignUpKeyword signUp = new SignUpKeyword(driver);

    login.clickNavbarSignInBtn();
    login.clickCreateBtn();
    signUp.clickSignInBtn();

    Assertions.assertTrue(loginPage.isPageOpen("login"));
  }

  @AfterEach
  void tearDown() {
    driver.quit();
  }
}
