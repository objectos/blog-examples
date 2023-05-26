/*
 * Copyright 2023 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package interrupted;

import java.util.concurrent.ThreadLocalRandom;

public class Multiplos01 extends Thread {
  private static final int VALUE = 111_222_333;

  public Multiplos01() { super("MULT1"); }

  @Override
  public void run() {
    var random = ThreadLocalRandom.current();

    while (true) {
      int next = random.nextInt();

      if (next > 0 && (next % VALUE) == 0) {
        var s = Integer.toString(next);

        Print.msg(s);
      }
    }
  }
}