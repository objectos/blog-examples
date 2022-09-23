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
package iter10;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import shared.Key;

public class HashTableTest {
  @Test(description = """
  put() method

  - handle hash collision
  - probe towards the end of array
  """)
  public void iter10a() {
    var ht = new HashTable<Key, String>();

    var a = new Key("AAA", 1);
    var b = new Key("BBB", 1);

    ht.put(a, "aaa");

    assertEquals(
      ht.toString(),
      """
      +-----+-----+-----+
      | idx | key | val |
      +-----+-----+-----+
      |   0 |     |     |
      |   1 | AAA | aaa |
      |   2 |     |     |
      |   3 |     |     |
      +-----+-----+-----+
      """
    );

    ht.put(b, "bbb");

    assertEquals(
      ht.toString(),
      """
      +-----+-----+-----+
      | idx | key | val |
      +-----+-----+-----+
      |   0 |     |     |
      |   1 | AAA | aaa |
      |   2 | BBB | bbb |
      |   3 |     |     |
      +-----+-----+-----+
      """
    );
  }

  @Test(description = """
  put() method

  - handle hash collision
  - value replacement
  - probe towards the end of array
  """)
  public void iter10b() {
    var ht = new HashTable<Key, String>();

    var a = new Key("AAA", 1);
    var b = new Key("BBB", 1);
    var c = new Key("CCC", 1);

    ht.put(a, "aaa");
    ht.put(b, "bob");
    ht.put(c, "ccc");
    ht.put(b, "bbb");

    assertEquals(
      ht.toString(),
      """
      +-----+-----+-----+
      | idx | key | val |
      +-----+-----+-----+
      |   0 |     |     |
      |   1 | AAA | aaa |
      |   2 | BBB | bbb |
      |   3 | CCC | ccc |
      +-----+-----+-----+
      """
    );
  }
}