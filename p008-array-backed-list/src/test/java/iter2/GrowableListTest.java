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
package iter2;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.UUID;
import org.testng.annotations.Test;

public class GrowableListTest {
  @Test
  public void test() {
    var list = new GrowableList<>();

    var arr = new Object[100_000];

    for (int i = 0; i < arr.length; i++) {
      var uuid = UUID.randomUUID();

      assertTrue(list.add(uuid));

      arr[i] = uuid;
    }

    assertEquals(list.toArray(), arr);
  }
}