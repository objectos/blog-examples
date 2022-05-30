/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package iter1;

import java.io.IOException;
import shared.Resource;

public class TryWithResources {
  public static void main(String[] args) throws IOException {
    try (var out = Resource.create("TWR")) {
      out.write("Try-with-resources statement (iteration 1)");
    }
  }
}
