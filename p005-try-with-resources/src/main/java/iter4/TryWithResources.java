/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package iter4;

import java.io.IOException;
import shared.Resource;

public class TryWithResources {
  public static void main(String[] args) throws IOException {
    try (var a = Resource.create("A"); var b = Resource.throwOnClose("B")) {
      a.write("Try-with-resources statement (iteration 4)");
      b.write("Try-with-resources statement (iteration 4)");
    }
  }
}
