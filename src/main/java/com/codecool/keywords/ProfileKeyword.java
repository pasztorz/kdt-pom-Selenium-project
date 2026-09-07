package com.codecool.keywords;

import com.codecool.pages.Navbar;
import com.codecool.pages.ProfilePage;
import org.openqa.selenium.WebDriver;

public class ProfileKeyword {
  private final ProfilePage profilePage;
  private final Navbar navbar;

  public ProfileKeyword(WebDriver driver) {
    this.profilePage = new ProfilePage(driver);
    this.navbar = new Navbar(driver);
  }

  public void openProfileForm() {
    openProfile();
    profilePage.clickProfileTabButton();
  }

  public void openProfile() {
    navbar.clickProfileButton();
  }
}
