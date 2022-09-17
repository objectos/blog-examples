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
package iter08b;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class HashTableTest {
  @Test
  public void iter06() {
    var ht = new HashTable<Integer, String>();

    assertEquals(ht.put(1, "One"), null);
    assertEquals(ht.put(2, "Two"), null);

    assertEquals(
      ht.toString(),
      """
      +-----+-----+-----+
      | idx | key | val |
      +-----+-----+-----+
      |   0 |     |     |
      |   1 |   1 | One |
      |   2 |   2 | Two |
      |   3 |     |     |
      +-----+-----+-----+
      """
    );
  }
}