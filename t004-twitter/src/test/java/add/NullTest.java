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
package add;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import org.testng.annotations.Test;

public class NullTest {

  @Test
  public void list() {
    var l0 = new ArrayList<String>();

    l0.add("A");
    l0.add("B");
    l0.add(null);
    l0.add("C");

    assertTrue(l0.contains(null));

    var l1 = new ArrayList<String>();

    l1.add("A");
    l1.add("B");
    l1.add("C");

    assertFalse(l1.contains(null));
  }

  @Test
  public void set() {
    var l0 = new HashSet<String>();

    l0.add("A");
    l0.add("B");
    l0.add(null);
    l0.add("C");

    assertTrue(l0.contains(null));

    var l1 = new HashSet<String>();

    l1.add("A");
    l1.add("B");
    l1.add("C");

    assertFalse(l1.contains(null));
  }

}
