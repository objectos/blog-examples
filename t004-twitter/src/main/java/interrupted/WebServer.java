/*
 * Copyright 2023 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package interrupted;

import java.util.concurrent.BlockingQueue;

public class WebServer extends Thread {
  private final BlockingQueue<String> queue;

  public WebServer(BlockingQueue<String> queue) {
    super("SERVER");
    this.queue = queue;
  }

  @Override
  public void run() {
    while (true) {
      try {
        Print.msg(queue.take());
      } catch (InterruptedException e) {
        Print.msg("Interrupção recebida");

        return;
      }
    }
  }
}