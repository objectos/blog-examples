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
package iter04;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class HashTableTest {
  @Test(description = """
  get() method

  - hash table contains the mapping
  - no hash collisions
  - positive hash codes
  """)
  public void iter04() {
    var ht = new HashTable<Integer, String>();
    assertEquals(ht.size(), 0);

    assertEquals(ht.put(1, "One"), null);
    assertEquals(ht.size(), 1);
    assertEquals(ht.get(1), "One");

    assertEquals(ht.put(2, "Two"), null);
    assertEquals(ht.size(), 2);
    assertEquals(ht.get(2), "Two");
  }
}