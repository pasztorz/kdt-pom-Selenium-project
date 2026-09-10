package com.codecool.service;

import java.util.concurrent.ThreadLocalRandom;

/// THIS PROVIDER IS FOR AVOIDING 'Verify You are Human' ALERT THAT COULD BLOCK THE TEST RUN
/// RESULTING FALSE FAIL OF TEST
public class IndifferentUrlProvider {
  private static final String[] URL_LIST = {
    "https://www.google.com/",
    "https://www.bing.com",
    "https://qatools.dev/",
    "https://selenium.dev/"
  };

  public IndifferentUrlProvider() {
  }

  public static String getRandomUrl() {
    int randomIndex = ThreadLocalRandom.current().nextInt(URL_LIST.length);
   return URL_LIST[randomIndex];
  }
}
