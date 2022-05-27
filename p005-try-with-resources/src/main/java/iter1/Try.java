/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package iter1;

import java.io.IOException;
import shared.SysOut;

public class Try {
  public static void main(String[] args) throws IOException {
    var out = SysOut.create("TRY");

    try {
      out.println("Try statement (iteration 1)");
    } finally {
      out.close();
    }
  }
}
