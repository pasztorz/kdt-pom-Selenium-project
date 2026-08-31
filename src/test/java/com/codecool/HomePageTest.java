package com.codecool;

import com.codecool.keywords.HomeKeyword;
import com.codecool.pages.Home;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePageTest {
  private WebDriver driver;
  private Home home;
  private HomeKeyword homeKeyword;

  @BeforeEach
  void setUp() {
    driver = new ChromeDriver();
    home = new Home(driver);
    homeKeyword = new HomeKeyword(driver);

    driver.manage().window().maximize();
  }

  @Test
  public void openHomeTest() {
    homeKeyword.openHome();

    Assertions.assertTrue(home.isPageOpen("https://playground.qatools.dev"));
  }

  @AfterEach
  void tearDown() {
    driver.quit();
  }
}
