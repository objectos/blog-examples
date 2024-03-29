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

import static org.testng.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Solucao02 {

  private final Set<String> names = new HashSet<>();

  public void addName(String name) {
    if (!names.add(name)) {
      throw new IllegalArgumentException(
        name + " já existe"
      );
    }
  }

  @Test
  public void add() {
    addName("A");
    addName("B");
    addName("C");

    assertEquals(names, Set.of("A", "B", "C"));

    try {
      addName("B");

      Assert.fail();
    } catch (IllegalArgumentException expected) {
      assertEquals(expected.getMessage(), "B já existe");
    }
  }

}
