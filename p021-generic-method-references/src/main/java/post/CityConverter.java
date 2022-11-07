/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package post;

public class CityConverter {
  static final CityConverter INSTANCE = new CityConverter();

  public String convert(City city) {
    var state = city.state();

    return """
    {"name": "%s", "state": "%s"}""".formatted(city.name(), state.abbr());
  }
}
