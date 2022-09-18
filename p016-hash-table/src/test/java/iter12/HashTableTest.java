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
package iter12;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import shared.Key;

public class HashTableTest {
  @Test(description = """
  get() test case

  - hash collision
  - non existing key
  """)
  public void iter09() {
    var ht = new HashTable<Key, String>();

    var a = new Key("AAA", 3);
    var b = new Key("BBB", 3);
    var c = new Key("CCC", 0);

    assertEquals(ht.put(a, "aaa"), null);
    assertEquals(ht.put(b, "bbb"), null);
    assertEquals(ht.put(c, "ccc"), null);

    var d = new Key("DDD", 1);

    assertEquals(ht.get(a), "aaa");
    assertEquals(ht.get(b), "bbb");
    assertEquals(ht.get(c), "ccc");
    assertEquals(ht.get(d), null);
  }
}