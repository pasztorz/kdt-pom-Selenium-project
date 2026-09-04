package com.codecool.service;

import com.codecool.model.GenderOption;

import java.util.concurrent.ThreadLocalRandom;

/** PROVIDERS ARE FOR GENERATING NEW USER CREDENTIALS AND SELECTED ELEMENTS FOR REPEATED SIGN UP TESTING
 * AND ENSURING ALL SIGNUP FIELDS ARE USED as part of these repeated tests reducing the chance of hidden bugs*/
public class GenderProvider {
  private final GenderOption[] genderOptions = GenderOption.values();

  public GenderProvider() {
  }

  public String getRandomGender() {
    int randomIndex = ThreadLocalRandom.current().nextInt(genderOptions.length);
    String randomGender = genderOptions[randomIndex].name();
    String firstLetter = randomGender.substring(0,1);
    String otherLetters = randomGender.substring(1).toLowerCase();

    return firstLetter + otherLetters;
  }
}
