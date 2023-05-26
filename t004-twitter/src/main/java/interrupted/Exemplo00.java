/*
 * Copyright 2023 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package interrupted;

import java.util.concurrent.TimeUnit;

public class Exemplo00 extends Thread {
  @Override
  public void run() {
    try {
      TimeUnit.SECONDS.sleep(5);
    } catch (InterruptedException e) {
      // ???
    }
  }
}
