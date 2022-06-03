/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package iter3;

public class Example {
  public static void main(String[] args) {
    say("Hello");

    var cntr = new Thread(
      Example::countdown, "cntr"
    );

    cntr.setDaemon(false);

    cntr.start();

    say("Bye");
  };

  private static void countdown() {
    say("Hello");

    say("3 second countdown!");

    for (int i = 3; i > 0; i--) {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        say("Got interrupted...");

        return;
      }

      say(Integer.toString(i));
    }

    say("Bye");
  }

  private static void say(String what) {
    var ct = Thread.currentThread();

    var name = ct.getName();

    System.out.println("%4s: %s".formatted(name, what));
  }
}