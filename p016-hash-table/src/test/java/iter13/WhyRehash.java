/*
 * Copyright (C) 2022 Objectos Software LTDA.
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
package iter13;

import shared.Key;

public class WhyRehash {
  public static void main(String[] args) {
    var a = new Key("AAA", 1);
    var b = new Key("BBB", 12);
    var c = new Key("CCC", 23);
    var d = new Key("DDD", 34);
    var e = new Key("EEE", 45);

    System.out.println("Capacity = 4");

    bucket(a, 4);
    bucket(b, 4);
    bucket(c, 4);
    bucket(d, 4);
    bucket(e, 4);

    System.out.println();
    System.out.println("Capacity = 8");

    bucket(a, 8);
    bucket(b, 8);
    bucket(c, 8);
    bucket(d, 8);
    bucket(e, 8);
  }

  private static void bucket(Object key, int capacity) {
    int hc = key.hashCode();

    var bucket = Math.floorMod(hc, capacity);

    System.out.format("Key(%s, %d) = %d%n", key, hc, bucket);
  }
}