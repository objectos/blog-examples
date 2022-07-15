/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package iter4;

class LogConverter {
  public String convert(Log log) {
    return """
    {millis: %d, level: "%s", msg: "%s"}
    """.formatted(log.millis(), log.level(), log.msg());
  }
}