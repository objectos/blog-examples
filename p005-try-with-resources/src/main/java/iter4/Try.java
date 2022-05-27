/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package iter4;

import java.io.IOException;
import shared.SysOut;

public class Try {
  public static void main(String[] args) throws IOException {
    var a = SysOut.create("A");

    var b = SysOut.throwOnClose("B");

    try {
      a.println("Try statement (iteration 4)");

      b.println("Try statement (iteration 4)");
    } finally {
      b.close();

      a.close();
    }
  }
}
