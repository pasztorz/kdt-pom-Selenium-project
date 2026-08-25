package com.codecool.model;

public class User {
  private static final int USER_ID = 1;

  private final int uniqueID;
  private final String name;
  private final String email;
  private final String password;

  public User(String name, String email, String password) {
    this.uniqueID = USER_ID + 1;
    this.name = name;
    this.email = email;
    this.password = password;
  }

  public int getUniqueID() {
    return uniqueID;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }
}
