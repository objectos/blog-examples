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
package iter02;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HashTableTest {
  @Test(description = """
  put() method

  - it must reject null keys
  - it must reject null values
  """)
  public void iter02() {
    var ht = new HashTable<String, String>();
    assertEquals(ht.size(), 0);

    try {
      ht.put(null, "non-null value");

      Assert.fail("Expected a NPE");
    } catch (NullPointerException expected) {
      assertEquals(expected.getMessage(), "key == null");
    }

    try {
      ht.put("non-null key", null);

      Assert.fail("Expected a NPE");
    } catch (NullPointerException expected) {
      assertEquals(expected.getMessage(), "value == null");
    }

    assertEquals(ht.size(), 0);
  }
}