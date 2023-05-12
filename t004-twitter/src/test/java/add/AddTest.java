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

public class AddTest {

  @Test
  public void list() {
    var letras = new ArrayList<String>();

    assertTrue(letras.add("A"));
    assertTrue(letras.add("B"));
    assertTrue(letras.add("B"));
    assertTrue(letras.add("C"));
  }

  @Test
  public void set() {
    var letras = new HashSet<String>();

    assertTrue(letras.add("A"));
    assertTrue(letras.add("B"));
    assertFalse(letras.add("B"));
    assertTrue(letras.add("C"));
  }

}
