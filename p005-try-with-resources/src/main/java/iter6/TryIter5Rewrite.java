/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package iter6;

import java.io.IOException;
import shared.Close;
import shared.Resource;

public class TryIter5Rewrite {
  public static void main(String[] args) throws IOException {
    Throwable rethrow = null;

    Resource a = null;
    Resource b = null;

    try {
      a = Resource.create("A");
      b = Resource.create("B");

      a.throwOnWrite("Try statement (iteration 5 rewrite)");
      b.write("Try statement (iteration 5 rewrite)");
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
