/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package iter3;

import java.io.IOException;
import shared.SysOut;

public class TryWithResources {
  public static void main(String[] args) throws IOException {
    try (var a = SysOut.create("A"); var b = SysOut.throwOnCreate("B")) {
      a.println("Try-with-resources statement (iteration 3)");

      b.println("Try-with-resources statement (iteration 3)");
    }
  }
}
