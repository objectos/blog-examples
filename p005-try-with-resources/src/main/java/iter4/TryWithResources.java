/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package iter4;

import java.io.IOException;
import shared.SysOut;

public class TryWithResources {
  public static void main(String[] args) throws IOException {
    try (var a = SysOut.create("A"); var b = SysOut.throwOnClose("B")) {
      a.println("Try-with-resources statement (iteration 4)");

      b.println("Try-with-resources statement (iteration 4)");
    }
  }
}
