/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package iter7;

import java.io.IOException;
import shared.Resource;

public class TryWithResources {
  public static void main(String[] args) {
    try (var a = Resource.create("A"); var b = Resource.create("B")) {
      a.write("Try-with-resources statement (iteration 7)");
      b.write("Try-with-resources statement (iteration 7)");
    } catch (IOException e) {
      System.err.println("The program failed: " + e.getMessage());

      return; // explicitly stop execution
    }

    System.out.println("More instructions...");
  }
}
