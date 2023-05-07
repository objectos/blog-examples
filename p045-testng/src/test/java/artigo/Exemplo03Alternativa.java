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

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

public class Exemplo03Alternativa {

  @Factory(dataProvider = "tester")
  public Object[] factory(Tester tester) {
    return new Object[] {
        new Exemplo03(tester)
    };
  }

  @DataProvider
  public Object[][] tester() {
    return new Object[][] {
        {Tester.OBJECTOS},

        {Tester.REFERENCIA}
    };
  }

}