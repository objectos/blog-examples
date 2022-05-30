/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package iter2;

import java.io.IOException;
import shared.Resource;

public class Try {
  // Warning: this code is problematic
  // It is written this way or educational purposes
  // Please avoid code like this in production
  public static void main(String[] args) throws IOException {
    var a = Resource.create("A");
    var b = Resource.create("B");

    try {
      a.write("Try statement (iteration 2)");
      b.write("Try statement (iteration 2)");
    } finally {
      a.close();
      b.close();
    }
  }
}
