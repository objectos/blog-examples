/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package iter4;

public class Example {
  private static Thread cntr;

  public static void main(String[] args) {
    say("Hello");

    cntr = new Thread(
      Example::countdown, "cntr"
    );

    var rt = Runtime.getRuntime();

    rt.addShutdownHook(
      new Thread(
        Example::hook, "hook"
      )
    );

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

  private static void hook() {
    say("Hello");

    cntr.interrupt();

    while (cntr.isAlive()) {
      say("cntr is alive");

      Thread.onSpinWait();
    }

    say("Bye");
  }

  private static void say(String what) {
    var ct = Thread.currentThread();

    var name = ct.getName();

    System.out.println("%4s: %s".formatted(name, what));
  }
}