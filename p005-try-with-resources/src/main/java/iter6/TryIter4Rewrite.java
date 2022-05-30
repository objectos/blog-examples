/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package iter6;

import java.io.IOException;
import shared.Close;
import shared.Resource;

public class TryIter4Rewrite {
  public static void main(String[] args) throws IOException {
    Throwable rethrow = null;

    Resource a = null;
    Resource b = null;

    try {
      a = Resource.create("A");
      b = Resource.throwOnClose("B");

      a.write("Try statement (iteration 4 rewrite)");
      b.write("Try statement (iteration 4 rewrite)");
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
