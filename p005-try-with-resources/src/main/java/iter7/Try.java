/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package iter7;

import java.io.IOException;
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

      a.write("Try statement (iteration 7)");
      b.write("Try statement (iteration 7)");
    } catch (Throwable e) {
      rethrow = e;
    } finally {
      rethrow = Close.ifPossible(rethrow, b);
      rethrow = Close.ifPossible(rethrow, a);
    }

    if (rethrow instanceof RuntimeException re) {
      throw re;
    }

    if (rethrow instanceof Error err) {
      throw err;
    }

    if (rethrow instanceof IOException ioe) {
      System.err.println("The program failed: " + ioe.getMessage());

      return; // explicitly stop execution
    }

    System.out.println("More instructions...");
  }
}
