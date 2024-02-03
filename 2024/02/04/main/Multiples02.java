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

import java.util.Random;

public class Multiples02 implements Runnable {
  
  public volatile int count;
  
  private final Random random = new Random();
  
  @Override
  public final void run() {
    while (true) {
      int next;
      next = random.nextInt();
      
      if (next <= 0) {
        continue;
      }
      
      if ((next % 111_222_333) != 0) {
        continue;
      }
     
      String found;
      found = Integer.toString(next);
        
      Logger.log(found);

      count++;
      
      if (Thread.interrupted()) {
        break;
      }
    }
  }
  
}