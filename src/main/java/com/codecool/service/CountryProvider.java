package com.codecool.service;

import com.codecool.model.CountryCode;

import java.util.concurrent.ThreadLocalRandom;

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
