package com.codecool.service;

import com.codecool.model.GenderOption;

import java.util.concurrent.ThreadLocalRandom;

public class GenderProvider {
  private final GenderOption[] genderOptions = GenderOption.values();

  public GenderProvider() {
  }

  public String getRandomGender() {
    int randomIndex = ThreadLocalRandom.current().nextInt(genderOptions.length);
    GenderOption randomGender = genderOptions[randomIndex];

    return randomGender.name();
  }
}
