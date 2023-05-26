/*
 * Copyright 2023 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package interrupted;

import java.util.concurrent.ThreadLocalRandom;

public class Multiplos02 extends Thread {
  private static final int VALUE = 111_222_333;
  public volatile int impressos;

  public Multiplos02() { super("MULTI2"); }

  @Override
  public void run() {
    var random = ThreadLocalRandom.current();

    while (!Thread.interrupted()) {
      int maybe = random.nextInt();

      if (maybe > 0 && (maybe % VALUE) == 0) {
        impressos++;

        var s = Integer.toString(maybe);

        Print.msg(s);
      }
    }
  }
}