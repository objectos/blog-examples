/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package iter1;

public class Example {
  public static void main(String[] args) {
    say("Hello");

    say("Bye");
  }

  private static void say(String what) {
    var ct = Thread.currentThread();

    var name = ct.getName();

    System.out.println("%4s: %s".formatted(name, what));
  }
}