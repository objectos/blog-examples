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