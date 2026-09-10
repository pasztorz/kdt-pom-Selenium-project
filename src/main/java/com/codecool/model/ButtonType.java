package com.codecool.model;

public enum ButtonType {
  APPOINTMENTS("My appointments");

  private final String text;

  ButtonType(String text) {
    this.text = text;
  }

  public String getText() {
    return text;
  }
}
