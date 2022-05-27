/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package iter1;

import java.io.IOException;
import shared.SysOut;

public class TryWithResources {
  public static void main(String[] args) throws IOException {
    try (var out = SysOut.create("TWR")) {
      out.println("Try-with-resources statement (iteration 1)");
    }
  }
}
