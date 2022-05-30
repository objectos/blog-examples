/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package iter3;

import java.io.IOException;
import shared.Resource;

public class TryWithResources {
  public static void main(String[] args) throws IOException {
    try (var a = Resource.create("A"); var b = Resource.throwOnCreate("B")) {
      a.write("Try-with-resources statement (iteration 3)");
      b.write("Try-with-resources statement (iteration 3)");
    }
  }
}
