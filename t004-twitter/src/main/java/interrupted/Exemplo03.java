/*
 * Copyright 2023 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package interrupted;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class Exemplo03 {
  public static void main(String[] args) throws InterruptedException {
    Print.msg("INÍCIO");

    var queue = new LinkedBlockingQueue<String>();

    var server = new WebServer(queue);

    server.start();

    work(queue);

    server.interrupt();

    server.join();

    Print.msg("FIM");
  }

  private static void work(LinkedBlockingQueue<String> queue) {
    var random = ThreadLocalRandom.current();

    int mensagens = 0;

    while (mensagens != 5) {
      int maybe = random.nextInt();

      if (maybe > 0 && (maybe % 111_222_333) == 0) {
        mensagens++;

        var mensagem = Integer.toString(maybe);

        queue.add(mensagem);
      }
    }
  }
}