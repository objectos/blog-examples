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
package iter16;

import static org.testng.Assert.assertEquals;

import iter14.HashTable;
import org.testng.Assert;
import org.testng.annotations.Test;
import shared.Key;

public class HashTableTest {
  @Test(description = """
  size() method

  - empty hash table must return 0
  """)
  public void iter01() {
    var ht = new HashTable<Object, Object>();
    assertEquals(ht.size(), 0);
  }

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

  @Test(description = """
  put() and size() methods

  - positive hash codes
  - no hash collisions
  - no value replacements
  """)
  public void iter03() {
    var ht = new HashTable<Integer, String>();
    assertEquals(ht.size(), 0);

    assertEquals(ht.put(1, "One"), null);
    assertEquals(ht.size(), 1);

    assertEquals(ht.put(2, "Two"), null);
    assertEquals(ht.size(), 2);
  }

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

  @Test(description = """
  put() & get() methods

  - negative hash code
  """)
  public void iter05() {
    var ht = new HashTable<Integer, String>();
    assertEquals(ht.size(), 0);

    assertEquals(ht.put(-1, "Minus One"), null);
    assertEquals(ht.size(), 1);
    assertEquals(ht.get(-1), "Minus One");

    assertEquals(ht.put(-2, "Minus Two"), null);
    assertEquals(ht.size(), 2);
    assertEquals(ht.get(-2), "Minus Two");
  }

  @Test(description = """
  put() & get() methods

  - negative hash code
  - positive hash code
  """)
  public void iter06() {
    var ht = new HashTable<Integer, String>();
    assertEquals(ht.size(), 0);

    assertEquals(ht.put(-3, "Minus Three"), null);
    assertEquals(ht.size(), 1);
    assertEquals(ht.get(-3), "Minus Three");

    assertEquals(ht.put(3, "Three"), null);
    assertEquals(ht.size(), 2);
    assertEquals(ht.get(3), "Three");
  }

  @Test(description = """
  put() method

  - replace the value mapped to an existing key
  """)
  public void iter07() {
    var ht = new HashTable<Integer, String>();
    assertEquals(ht.size(), 0);

    assertEquals(ht.put(1, "Won"), null);
    assertEquals(ht.size(), 1);

    assertEquals(ht.put(1, "One"), "Won");
    assertEquals(ht.size(), 1);

    assertEquals(ht.put(2, "Two"), null);
    assertEquals(ht.size(), 2);

    assertEquals(ht.get(1), "One");
    assertEquals(ht.get(2), "Two");
  }

  @Test(description = """
  get() method

  - non-existing key should return null
  """)
  public void iter08() {
    var ht = new HashTable<Integer, String>();

    assertEquals(ht.get(1), null);

    assertEquals(ht.put(1, "One"), null);

    assertEquals(ht.get(1), "One");
  }

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

  @Test(description = """
  put() method

  - handle hash collisions
  - no value replacement
  """)
  public void iter10() {
    var ht = new HashTable<Key, String>();

    var a = new Key("AAA", 2);
    var b = new Key("BBB", 2);
    var c = new Key("CCC", 2);

    assertEquals(ht.put(a, "aaa"), null);
    assertEquals(ht.put(b, "bbb"), null);
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

  @Test(description = """
  get() test case

  - hash collision
  - non existing key
  """)
  public void iter12() {
    var ht = new HashTable<Key, String>();

    var a = new Key("AAA", 3);
    var b = new Key("BBB", 3);
    var c = new Key("CCC", 3);

    assertEquals(ht.put(a, "aaa"), null);
    assertEquals(ht.put(b, "bbb"), null);
    assertEquals(ht.put(c, "ccc"), null);

    assertEquals(ht.get(a), "aaa");
    assertEquals(ht.get(b), "bbb");
    assertEquals(ht.get(c), "ccc");

    var d = new Key("DDD", 3);

    assertEquals(ht.get(d), null);
  }

  @Test(description = """
  put() test case

  - assume load factor 0.75
  - should resize on 4th insert
  - no hash collisions
  """)
  public void iter13() {
    var ht = new HashTable<Key, String>();

    var a = new Key("AAA", 2);
    var b = new Key("BBB", 6);
    var c = new Key("CCC", 3);

    assertEquals(ht.put(a, "aaa"), null);
    assertEquals(ht.put(b, "bbb"), null);
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

    var d = new Key("DDD", 0);

    assertEquals(ht.put(d, "ddd"), null);

    assertEquals(
      ht.toString(),
      """
      +-----+-----+-----+
      | idx | key | val |
      +-----+-----+-----+
      |   0 | DDD | ddd |
      |   1 |     |     |
      |   2 | AAA | aaa |
      |   3 | CCC | ccc |
      |   4 |     |     |
      |   5 |     |     |
      |   6 | BBB | bbb |
      |   7 |     |     |
      +-----+-----+-----+
      """
    );
  }

  @Test(description = """
  put() test case

  - refactor bucket() method
  """)
  public void iter14() {
    var ht = new HashTable<Key, String>();

    var a = new Key("AAA", 1);
    var b = new Key("BBB", 2);
    var c = new Key("CCC", 3);
    var d = new Key("DDD", 4);

    assertEquals(ht.put(a, "aaa"), null);
    assertEquals(ht.put(b, "bbb"), null);
    assertEquals(ht.put(c, "ccc"), null);
    assertEquals(ht.put(d, "ddd"), null);

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
      |   4 | DDD | ddd |
      |   5 |     |     |
      |   6 |     |     |
      |   7 |     |     |
      +-----+-----+-----+
      """
    );
  }
}