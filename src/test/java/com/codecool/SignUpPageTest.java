package com.codecool;

import com.codecool.keywords.HomeKeyword;
import com.codecool.keywords.LoginKeyword;
import com.codecool.keywords.SignUpKeyword;
import com.codecool.pages.SignUpPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignUpPageTest {
  private WebDriver driver;
  private SignUpPage signUpPage;
  private SignUpKeyword signUp;
  private LoginKeyword login;

  @BeforeEach
  void setUp() {
    driver = new ChromeDriver();
    signUpPage = new SignUpPage(driver);
    signUp = new SignUpKeyword(driver);
    login = new LoginKeyword(driver);

    driver.manage().window().maximize();

    HomeKeyword home = new HomeKeyword(driver);

    home.open();
    login.clickNavbarSignInBtn();
  }

  @Test
  public void openSignUpPageWithCreateButtonTest() {
    login.clickCreateBtn();

    Assertions.assertTrue(signUpPage.isPageOpen("/signup"));
  }

  @AfterEach
  void tearDown() {
    driver.quit();
  }
}
