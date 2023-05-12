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

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

public class Item02 {

  public String[] exemplo01() {
    return new String[] {
        "Vou-me", "embora", "pra", "Pasárgada"
    };
  }

  public String exemplo02()[] {
    return new String[] {
        "Vou-me", "embora", "pra", "Pasárgada"
    };
  }

  public String[] exemplo03()[] {
    return new String[][] {
        {"Vou-me", "embora", "pra", "Pasárgada"},
        {"No", "meio", "do", "caminho"}
    };
  }

  @Target(ElementType.TYPE_USE)
  @interface Eita {}

  @Target(ElementType.TYPE_USE)
  @interface Vixe {}

  public @Eita String @Eita [] exemplo04() @Eita @Vixe [] {
    return new String[][] {
        {"Vou-me", "embora", "pra", "Pasárgada"},
        {"No", "meio", "do", "caminho"}
    };
  }

  public @Eita String @Eita [] exemplo05() @Eita @Vixe [] {
    return new @Eita String @Vixe [] @Eita @Vixe [] {
        {"Vou-me", "embora", "pra", "Pasárgada"},
        {"No", "meio", "do", "caminho"}
    };
  }

}