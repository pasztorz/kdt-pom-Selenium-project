package com.codecool.keywords;

import com.codecool.pages.Navbar;
import org.openqa.selenium.WebDriver;

public class NavbarKeyword {
  private final Navbar navbar;

  public NavbarKeyword(WebDriver driver) {
    this.navbar = new Navbar(driver);
  }

  public void logOut() {
    navbar.clickLogOutButton();
  }
}
