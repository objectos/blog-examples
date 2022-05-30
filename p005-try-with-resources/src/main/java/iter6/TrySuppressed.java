/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package iter6;

import java.io.IOException;
import shared.Close;
import shared.Resource;

public class TrySuppressed {
  public static void main(String[] args) throws IOException {
    Throwable rethrow = null;

    Resource a = null;
    Resource b = null;

    try {
      a = Resource.create("A");
      b = Resource.throwOnClose("B");

      a.throwOnWrite("Try statement (suppressed in action)");
      b.write("Try statement (suppressed in action)");
    } catch (Throwable e) {
      rethrow = e;
    } finally {
      rethrow = Close.ifPossible(rethrow, b);
      rethrow = Close.ifPossible(rethrow, a);
    }

    if (rethrow != null) {
      System.err.println("The program failed: " + rethrow.getMessage());

      for (Throwable s : rethrow.getSuppressed()) {
        System.err.println("\tsuppressed: " + s.getMessage());
      }

      return; // explicitly stop execution
    }

    System.out.println("More instructions...");
  }
}
