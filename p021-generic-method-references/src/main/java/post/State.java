/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package post;

public record State(String abbr) {
  public City newCity(String name) { return new City(name, this); }
}