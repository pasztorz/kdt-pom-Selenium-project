package com.codecool.service;

public class CredentialsProvider {
  private final String firstName;
  private final String lastName;

  public CredentialsProvider(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String createTestPassword() {
    String firstLetter = firstName.substring(0, 1).toLowerCase();
    String secondLetter = lastName.substring(0, 1);

    return firstLetter + secondLetter + "1@Register";
  }

  public String createTestEmail() {
    return firstName + "1." + lastName + "@example.com";
  }

  public String createTestFullName() {
    return firstName + "1 " + lastName;
  }
}
