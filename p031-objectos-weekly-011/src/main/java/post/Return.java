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
package post;

import java.util.concurrent.ThreadLocalRandom;

public class Return {

  {
    int value = random();

    if (value < 0) {
      //return;
    }

    compute(value);
  }

  private void compute(int value) {
    // do computation
  }

  private int random() {
    return ThreadLocalRandom.current().nextInt();
  }

}