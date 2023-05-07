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

import org.testng.annotations.Test;

public class Exemplo03 {

  Tester tester = Tester.OBJECTOS;

  public Exemplo03() {}

  Exemplo03(Tester tester) {
    this.tester = tester;
  }

  @Test(description = """
  Testar o caminho feliz
  - entrada válida
  - entrada formatada c/ espaço depois da vírgula
  """)
  public void teste() {
    var entrada = "4, 8, 15, 16, 23, 42";

    var saida = new int[] {4, 8, 15, 16, 23, 42};

    tester.test(entrada, saida);
  }

}