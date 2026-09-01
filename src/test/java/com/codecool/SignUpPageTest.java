package com.codecool;

import com.codecool.keywords.HomeKeyword;
import com.codecool.keywords.SignUpKeyword;
import com.codecool.pages.SignUpPage;
import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignUpPageTest {
  private WebDriver driver;
  private SignUpPage signUpPage;
  private SignUpKeyword signUpKeyword;

  @BeforeEach
  void setUp() {
    driver = new ChromeDriver();
    signUpPage = new SignUpPage(driver);
    signUpKeyword = new SignUpKeyword(driver);

    driver.manage().window().maximize();

    HomeKeyword homeKeyword = new HomeKeyword(driver);
    homeKeyword.openHome();
  }

  @Test
  public void signUp() {
    Dotenv dotenv = Dotenv.load();
    String firstName = dotenv.get("DEFAULT_NEW_TEST_USER_FIRSTNAME");
    String lastName = dotenv.get("DEFAULT_NEW_TEST_USER_LASTNAME");

    signUpKeyword.openFromLoginPage();
    signUpKeyword.signUp(firstName, lastName);
  }

  @Test
  public void openFromLoginPageWithCreateButtonTest() {
    signUpKeyword.openFromLoginPage();

    Assertions.assertTrue(signUpPage.isPageOpen("/signup"));
  }

  @AfterEach
  void tearDown() {
    //driver.quit();
  }
}
