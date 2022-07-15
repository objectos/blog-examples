/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package iter4;

import static org.testng.Assert.assertEquals;

import java.util.logging.Level;
import org.testng.annotations.Test;

public class PayloadTest {
  Log log = new Log(12345L, Level.INFO, "Hello world");

  LogConverter formatter = new LogConverter();

  @Test
  public void invoke() {
    var p = new Payload(formatter::convert, log);

    assertEquals(p.data(), """
    {millis: 12345, level: "INFO", msg: "Hello world"}
    """);
  }
}