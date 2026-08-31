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

public class LoginTest {
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
  public void openLoginPageWithNavbarButtonTest() {
    login.clickNavbarSignInBtn();

    Assertions.assertTrue(loginPage.isPageOpen("login"));
  }

  @AfterEach
  void tearDown() {
    driver.quit();
  }
}
