package com.codecool.service;

import com.codecool.model.CountryCode;

import java.util.concurrent.ThreadLocalRandom;

/** PROVIDERS ARE FOR GENERATING NEW USER CREDENTIALS AND SELECTED ELEMENTS FOR REPEATED SIGN UP TESTING
 * AND ENSURING ALL SIGNUP FIELDS ARE USED as part of these repeated tests reducing the chance of hidden bugs*/
public class CountryProvider {
  private final CountryCode[] countryCodes = CountryCode.values();

  public CountryProvider() {
  }

  public String getRandomCountry() {
    int randomIndex = ThreadLocalRandom.current().nextInt(countryCodes.length);
    CountryCode randomCountryCode = countryCodes[randomIndex];

    return randomCountryCode.name();
  }
}
