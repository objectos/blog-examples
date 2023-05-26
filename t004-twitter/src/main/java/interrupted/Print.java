/*
 * Copyright 2023 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package interrupted;

public class Print {
  private Print() {}

  public static void msg(String value) {
    var currentThread = Thread.currentThread();

    var name = currentThread.getName();

    System.out.format("%6s: %s%n", name, value);
  }
}