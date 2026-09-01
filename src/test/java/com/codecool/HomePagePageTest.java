package com.codecool;

import com.codecool.keywords.HomeKeyword;
import com.codecool.pages.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePagePageTest {
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
    homeKeyword.openHome();

    Assertions.assertTrue(homePage.isPageOpen("https://playground.qatools.dev"));
  }

  @AfterEach
  void tearDown() {
    driver.quit();
  }
}
