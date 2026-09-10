package com.codecool.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class NavbarLocator {

  @FindBy(css = "nav[aria-label='Primary navigation']")
  private WebElement primaryNavbar;

  @FindBys({
    @FindBy(css = "nav[aria-label='Primary navigation']"),
    @FindBy(tagName = "a")
  })
  private List<WebElement> navbarNavButtonList;

  @FindBy(css = ".navbar-brand-main")
  private WebElement homeButton;

  @FindBy(css = ".btn.nav-cta")
  private WebElement signInButton;

  @FindBy(css = "button[class='btn-secondary']")
  private WebElement logOutButton;

  @FindBy(css = ".nav-link[data-testid='nav-profile']")
  private WebElement profileButton;

  public NavbarLocator(WebDriver driver) {
    PageFactory.initElements(driver, this);
  }

  public WebElement getPrimaryNavbar() {
    return primaryNavbar;
  }

  public List<WebElement> getNavbarNavButtonList() {
    return navbarNavButtonList;
  }

  public WebElement getHomeButton() {
    return homeButton;
  }

  public WebElement getSignInButton() {
    return signInButton;
  }

  public WebElement getLogOutButton() {
    return logOutButton;
  }

  public WebElement getProfileButton() {
    return profileButton;
  }
}
