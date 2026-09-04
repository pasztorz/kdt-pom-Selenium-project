package com.codecool.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/** PROVIDERS ARE FOR GENERATING NEW USER CREDENTIALS AND SELECTED ELEMENTS FOR REPEATED SIGN UP TESTING
 * AND ENSURING ALL SIGNUP FIELDS ARE USED as part of these repeated tests reducing the chance of hidden bugs*/
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

    return firstLetter + secondLetter + "@" + getTimeStamp();
  }

  public String createTestEmail() {
    return firstName.toLowerCase() + "." + lastName.toLowerCase() + getTimeStamp() + "@example.com";
  }

  public String createTestName() {
    return firstName + " " + lastName;
  }

  public String getTimeStamp() {
    LocalDateTime timeOfSignUp = LocalDateTime.now();
    DateTimeFormatter format = DateTimeFormatter.ofPattern("MMddyy-hhmmss");

    return timeOfSignUp.format(format);
  }
}
