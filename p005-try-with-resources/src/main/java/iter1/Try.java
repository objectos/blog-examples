/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package iter1;

import java.io.IOException;
import shared.Resource;

public class Try {
  public static void main(String[] args) throws IOException {
    var out = Resource.create("TRY");

    try {
      out.write("Try statement (iteration 1)");
    } finally {
      out.close();
    }
  }
}
