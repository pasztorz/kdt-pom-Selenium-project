package com.codecool.service;

import com.codecool.model.CountryCode;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ValidCountryProvider {
  private final CountryCode[] countryCodes = CountryCode.values();

  public ValidCountryProvider() {
  }

  public String getRandomCountry() {
    int randomIndex = ThreadLocalRandom.current().nextInt(countryCodes.length);
    CountryCode randomCountryCode = countryCodes[randomIndex];

    return randomCountryCode.name();
  }
}
