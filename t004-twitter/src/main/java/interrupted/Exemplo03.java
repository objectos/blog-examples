/*
 * Copyright (C) 2022-2023 Objectos Software LTDA.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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