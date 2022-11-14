package com.obligatorio2;

import io.github.cdimascio.dotenv.Dotenv;

public class Main {

  public static void main(String[] args) {
    Dotenv.configure()
        .filename(".env")
        .systemProperties()
        .load();
  
  }
}
