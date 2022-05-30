/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package iter6;

import shared.Resource;

public class TryWithResources {
  public static void main(String[] args) {
    try (var a = Resource.create("A"); var b = Resource.create("B")) {
      a.write("Try-with-resources statement (iteration 6)");
      b.write("Try-with-resources statement (iteration 6)");
    } catch (Throwable e) {
      System.err.println("The program failed: " + e.getMessage());

      return; // explicitly stop execution
    }

    System.out.println("More instructions...");
  }
}
