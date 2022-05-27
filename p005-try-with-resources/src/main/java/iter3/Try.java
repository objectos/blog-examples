/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package iter3;

import java.io.IOException;
import shared.SysOut;

public class Try {
  public static void main(String[] args) throws IOException {
    var a = SysOut.create("A");

    var b = SysOut.throwOnCreate("B");

    try {
      a.println("Try statement (iteration 3)");

      b.println("Try statement (iteration 3)");
    } finally {
      b.close();

      a.close();
    }
  }
}
