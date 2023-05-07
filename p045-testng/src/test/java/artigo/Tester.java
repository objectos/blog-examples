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

public abstract class Tester {
  static final Tester OBJECTOS = new Tester() {
    @Override
    public final void test(String entrada, int[] saida) {
      var parser = new Objectos();

      int[] res = parser.parse(entrada);

      assertEquals(res, saida);
    }
  };

  static final Tester REFERENCIA = new Tester() {
    @Override
    public final void test(String entrada, int[] saida) {
      int[] res = Referencia.parse(entrada);

      assertEquals(res, saida);
    }
  };

  Tester() {}

  public abstract void test(String entrada, int[] saida);
}