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
package set;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class TweetSetTest {

  @Test
  public void add() {
    var set = new TweetSet<String>();

    assertEquals(set.size(), 0);

    assertTrue(set.add("abc"));
    assertTrue(set.add("789"));
    assertTrue(set.add("FGH"));

    assertEquals(set.size(), 3);

    assertEquals(
      set.toString(),

      """
      +-----+-----+
      | idx | val |
      +-----+-----+
      |   0 | 789 |
      |   1 |     |
      |   2 | abc |
      |   3 |     |
      |   4 |     |
      |   5 |     |
      |   6 |     |
      |   7 | FGH |
      +-----+-----+
      """
    );
  }

  @Test(enabled = false)
  public void loop() {
    var set = new TweetSet<String>();

    set.add("11");
    set.add("22");
    set.add("33");
    set.add("44");
    set.add("55");
    set.add("66");
    set.add("77");
    set.add("88");

    // loop infinito...
    set.add("99");
  }

}
