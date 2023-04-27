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
package thread;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class Tweet02 {
  @SuppressWarnings("unused")
  public static void main(String[] args) {
    var t1 = new <Random> Thread();
    var t2 = new <Integer, Void, Double> Thread();
    var t3 = new <Map<String, List<Thread>>> Thread();

    t1.start();
    t2.start();
    t3.start();

    System.out.println("Cheguei no fim!");
  }
}
