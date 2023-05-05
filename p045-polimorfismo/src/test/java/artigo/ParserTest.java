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
package artigo;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class ParserTest {

  @Test(enabled = false, description = """
  Testar o caminho feliz
  - entrada válida
  - entrada formatada c/ espaço depois da vírgula
  """)
  public void testCase01() {
    var parser = new Parser();

    int[] res = parser.parse("4, 8, 15, 16, 23, 42");

    assertEquals(res.length, 6);
    assertEquals(res[0], 4);
    assertEquals(res[1], 8);
    assertEquals(res[2], 15);
    assertEquals(res[3], 16);
    assertEquals(res[4], 23);
    assertEquals(res[5], 42);
  }

}