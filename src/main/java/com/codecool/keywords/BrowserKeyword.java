package com.codecool.keywords;

import com.codecool.service.IndifferentUrlProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserKeyword {
  private final WebDriver driver;

  public BrowserKeyword(WebDriver driver) {
    this.driver = driver;
  }

  public void closeOpenedBrowser() {
    driver.close();
  }

  public WebDriver openNewPersistentChrome() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--user-data-dir=/some/test/profile");

    WebDriver newDriver = new ChromeDriver(options);
    newDriver.manage().window().maximize();

    return newDriver;
  }

  public WebDriver openNewFreshChrome() {
    WebDriver newDriver = new ChromeDriver();
    newDriver.manage().window().maximize();

    return newDriver;
  }

  public void navigateBack() {
    driver.navigate().back();
  }

  public void navigateToIndifferentWebPageInBrowser() {
    String url = IndifferentUrlProvider.getRandomUrl();
    driver.navigate().to(url);
  }
}
