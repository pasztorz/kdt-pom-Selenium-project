package com.codecool.service;

public class CredentialsProvider {
  private static int ID_COUNTER = 1;

  private final String  userID;
  private final String firstName;
  private final String lastName;

  public CredentialsProvider(String firstName, String lastName) {
    this.userID = Integer.toString(ID_COUNTER /*for later repeated signup tests: + 1*/);
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String createTestPassword() {
    String firstLetter = firstName.substring(0, 1).toLowerCase();
    String secondLetter = lastName.substring(0, 1);

    return firstLetter + secondLetter + userID + "@Register";
  }

  public String createTestEmail() {
    return firstName.toLowerCase() + userID + "." + lastName.toLowerCase() + "@example.com";
  }

  public String createTestFullName() {
    return firstName + userID + " " + lastName;
  }
}
