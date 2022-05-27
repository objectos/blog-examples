/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package iter2;

import java.io.IOException;
import shared.SysOut;

public class TryWithResources {
  public static void main(String[] args) throws IOException {
    try (var a = SysOut.create("A"); var b = SysOut.create("B")) {
      a.println("Try-with-resources statement (iteration 2)");

      b.println("Try-with-resources statement (iteration 2)");
    }
  }
}
