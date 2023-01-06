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
package iter09;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import shared.Key;

public class HashTableTest {
  @Test(description = """
  toString() method

  - renders an ascii table with columns:

  1. array index
  2. key toString()
  3. value toString()
  """)
  public void iter09() {
    var ht = new HashTable<Key, String>();

    var a = new Key("AAA", 4);
    var c = new Key("CCC", 6);

    ht.put(a, "aaa");
    ht.put(c, "ccc");

    assertEquals(
      ht.toString(),
      """
      +-----+-----+-----+
      | idx | key | val |
      +-----+-----+-----+
      |   0 | AAA | aaa |
      |   1 |     |     |
      |   2 | CCC | ccc |
      |   3 |     |     |
      +-----+-----+-----+
      """
    );
  }
}