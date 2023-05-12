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

public class Item01 {

  @Target(ElementType.METHOD)
  public @interface Banda {
    Integrante[] value() default {};
  }

  @Target(ElementType.ANNOTATION_TYPE)
  public @interface Integrante {
    String value();
  }

  public static class Exemplo01 {
    public @Banda({
        @Integrante("Iommi"),
        @Integrante("Butler"),
        @Integrante("Osbourne"),
        @Integrante("Ward")
    }) final String naoFacaIsto() {
      return "Não escreva códigos assim...";
    }
  }

  @Target(ElementType.METHOD)
  public @interface Pegue {
    String value();
  }

  public static class Exemplo02 {
    @Pegue("/a")
    public final String methodA() {
      return "Prefira esta forma";
    }

    public @Pegue("/b") final String methodB() {
      return "Compila, mas evite!";
    }

    public final @Pegue("/c") String methodC() {
      return "Compila, mas evite também!";
    }
  }

}