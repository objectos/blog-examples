/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package iter5;

import java.io.IOException;
import shared.Resource;

public class Try {
  // Warning: this code is problematic
  // It is written this way or educational purposes
  // Please avoid code like this in production
  public static void main(String[] args) throws IOException {
    Resource a = null;
    Resource b = null;

    try {
      a = Resource.create("A");
      a.throwOnWrite("Try statement (iteration 5)");

      b = Resource.create("B");
      b.write("Try statement (iteration 5)");
    } catch (IOException e) {
      System.err.println("The program failed: " + e.getMessage());

      return; // explicitly stop execution
    } finally {
      // do not do this!!
      b.close();
      a.close();
    }

    System.out.println("More instructions...");
  }
}
