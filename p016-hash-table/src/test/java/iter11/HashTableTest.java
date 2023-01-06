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
package iter11;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import shared.Key;

public class HashTableTest {
  @Test(description = """
  put() method

  - hash collision
  - value replacement
  """)
  public void iter11() {
    var ht = new HashTable<Key, String>();

    var a = new Key("AAA", 2);
    var b = new Key("BBB", 2);

    assertEquals(ht.put(a, "aaa"), null);
    assertEquals(ht.put(b, "123"), null);
    assertEquals(ht.put(b, "bbb"), "123", "\n" + ht.toString());

    var c = new Key("CCC", 3);

    assertEquals(ht.put(c, "ccc"), null);

    assertEquals(
      ht.toString(),
      """
      +-----+-----+-----+
      | idx | key | val |
      +-----+-----+-----+
      |   0 | CCC | ccc |
      |   1 |     |     |
      |   2 | AAA | aaa |
      |   3 | BBB | bbb |
      +-----+-----+-----+
      """
    );
  }

  @Test(enabled = false, description = """
  put() method

  - guaranteed to cause an infinite loop
  """)
  public void iter11_infiniteLoop() {
    var ht = new HashTable<Key, String>();

    var a = new Key("AAA", 2);
    var b = new Key("BBB", 2);
    var c = new Key("CCC", 2);
    var d = new Key("DDD", 2);
    var e = new Key("EEE", 2);

    ht.put(a, "aaa");
    ht.put(b, "bbb");
    ht.put(c, "ccc");
    ht.put(d, "ddd");
    ht.put(e, "eee");
  }
}