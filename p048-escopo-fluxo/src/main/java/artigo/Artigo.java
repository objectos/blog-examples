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

import java.time.LocalDate;
import java.util.Objects;

public class Artigo {

  String titulo;

  LocalDate data;

  static class Version01 extends Artigo {
    @Override
    public boolean equals(Object obj) {
      if (obj instanceof Artigo) {
        Artigo that = (Artigo) obj;

        return Objects.equals(titulo, that.titulo)
            && Objects.equals(data, that.data);
      } else {
        return false;
      }
    }
  }

  static class Version02 extends Artigo {
    @Override
    public boolean equals(Object obj) {
      if (obj instanceof Artigo that) {
        return Objects.equals(titulo, that.titulo)
            && Objects.equals(data, that.data);
      } else {
        return false;
      }
    }
  }

  static class Version03 extends Artigo {
    @Override
    public boolean equals(Object obj) {
      return obj instanceof Artigo that
          && Objects.equals(titulo, that.titulo)
          && Objects.equals(data, that.data);
    }
  }

  static class Version04 extends Artigo {
    @Override
    public boolean equals(Object obj) {
      return obj == this || obj instanceof Artigo that
          && Objects.equals(titulo, that.titulo)
          && Objects.equals(data, that.data);
    }
  }

}