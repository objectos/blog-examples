/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package iter6;

import shared.Close;
import shared.Resource;

public class Try {
  public static void main(String[] args) {
    Throwable rethrow = null;

    Resource a = null;
    Resource b = null;

    try {
      a = Resource.create("A");
      b = Resource.create("B");

      a.write("Try statement (iteration 6)");
      b.write("Try statement (iteration 6)");
    } catch (Throwable e) {
      rethrow = e;
    } finally {
      rethrow = Close.ifPossible(rethrow, b);
      rethrow = Close.ifPossible(rethrow, a);
    }

    if (rethrow != null) {
      System.err.println("The program failed: " + rethrow.getMessage());

      return; // explicitly stop execution
    }

    System.out.println("More instructions...");
  }
}
