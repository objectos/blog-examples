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
package iter1;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import shared.Key;

public class HashTableTest {
  @Test
  public void happyPath() {
    var a = new Key("AAA", 11);
    var b = new Key("BBB", 22);
    var c = new Key("CCC", 33);
    var d = new Key("DDD", 44);

    var ht = new HashTable();

    assertEquals(ht.put(a, "AAA"), null);
    assertEquals(ht.put(a, "aaa"), "AAA");
    assertEquals(ht.put(b, "bbb"), null);
    assertEquals(ht.put(c, "ccc"), null);

    assertEquals(ht.size(), 3);

    assertEquals(ht.get(a), "aaa");
    assertEquals(ht.get(b), "bbb");
    assertEquals(ht.get(c), "ccc");
    assertEquals(ht.get(d), null);

    assertEquals(
      ht.toString(),
      """
      +-----+-----+-----+
      | idx | key | val |
      +-----+-----+-----+
      |   0 |     |     |
      |   1 | CCC | ccc |
      |   2 |     |     |
      |   3 | AAA | aaa |
      |   4 |     |     |
      |   5 |     |     |
      |   6 | BBB | bbb |
      |   7 |     |     |
      +-----+-----+-----+
      """
    );
  }
}