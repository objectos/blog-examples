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

    cntr.setDaemon(true);

    cntr.start();

    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      say("Got interrupted...");

      return;
    }

    say("Bye");
  };

  private static void countdown() {
    say("Hello");

    say("3 seconds countdown!");

    for (int i = 3; i > 0; i--) {
      say(Integer.toString(i));

      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        say("Got interrupted...");

        return;
      }
    }

    say("Bye");
  }

  private static void say(String what) {
    var ct = Thread.currentThread();

    var name = ct.getName();

    System.out.println("%4s: %s".formatted(name, what));
  }
}