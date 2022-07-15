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
package iter1;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import org.testng.annotations.Test;

public class CharAtTest {
  @Test
  public void sort() {
    var list = new ArrayList<CharAt<String>>();

    list.add(new CharAt<>("c"));
    list.add(new CharAt<>("b"));
    list.add(new CharAt<>("a"));

    Collections.sort(list);

    assertEquals(list.toString(), "[a, b, c]");
  }
}