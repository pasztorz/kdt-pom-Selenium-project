package com.codecool;

import com.codecool.keywords.HomeKeyword;
import com.codecool.pages.HomePage;
import com.codecool.pages.Navbar;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePageTest {
  private WebDriver driver;
  private HomePage homePage;
  private HomeKeyword homeKeyword;

  @BeforeEach
  void setUp() {
    driver = new ChromeDriver();
    homePage = new HomePage(driver);
    homeKeyword = new HomeKeyword(driver);

    driver.manage().window().maximize();
  }

  @Test
  public void openHomeTest() {
    Navbar navbar = new Navbar(driver);

    homeKeyword.openHome();

    Assertions.assertTrue(navbar.isHomeButtonDisplayed());
    Assertions.assertTrue(navbar.isLoginDisplayed());
    Assertions.assertTrue(homePage.currentUrlEquals("https://playground.qatools.dev/"));
  }

  @AfterEach
  void tearDown() {
    driver.quit();
  }
}
