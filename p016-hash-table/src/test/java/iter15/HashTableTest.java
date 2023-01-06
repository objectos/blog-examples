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
package iter15;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import shared.Key;

public class HashTableTest {
  @Test(description = """
  put() test case

  - refactor bucket() method
  """)
  public void iter15() {
    var ht = new HashTable<Key, String>();

    var a = new Key("AAA", 1);
    var b = new Key("BBB", 12);
    var c = new Key("CCC", 23);
    var d = new Key("DDD", 34);
    var e = new Key("EEE", 45);

    ht.put(a, "aaa");
    ht.put(b, "bbb");
    ht.put(c, "ccc");
    ht.put(d, "ddd");
    ht.put(e, "eee");

    assertEquals(ht.get(a), "aaa");
    assertEquals(ht.get(b), "bbb");
    assertEquals(ht.get(c), "ccc");
    assertEquals(ht.get(d), "ddd");
    assertEquals(ht.get(e), "eee");
  }
}