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
package annotations;

public class Item01 {

  @interface Entidade {}

  @interface Tabela {
    String name();
  }

  @interface Id {}

  @interface Coluna {
    String name() default "";
  }

  public @Entidade @Tabela(name = "USUARIO") class User {

    private @Id int id;

    private @Coluna(name = "LOGIN") String login;

    User() {}

  }

  interface Foo01 {
    public class Anotações {
      public @Override final String toString() {
        return "Anotação no meio dos modificadores";
      }
    }
  }

  interface Foo02 {
    public class Anotações {
      public final @Override String toString() {
        return "Anotação é o último modificador";
      }
    }
  }

}