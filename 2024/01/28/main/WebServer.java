/*
 * Copyright (C) 2024 Objectos Software LTDA.
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
package objectos;

import java.util.concurrent.BlockingQueue;

public class WebServer implements Runnable {
  
  private final BlockingQueue<String> queue;

  WebServer(BlockingQueue<String> queue) {
    this.queue = queue;
  }
  
  @Override
  public final void run() {
    while (true) {
      try {
        String msg;
        msg = queue.take();
        
        Logger.log(msg);
      } catch (InterruptedException e) {
        Logger.log("Got interrupted!");
        
        break;
      }
    }
  }
  
}