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

public class Item03 {

  @Target(ElementType.TYPE_USE)
  @interface A {}

  @Target(ElementType.TYPE_USE)
  @interface B {}

  @Target(ElementType.TYPE_USE)
  @interface C {}

  public class Exemplo01 {
    public int[][] a;
  }

  public class Exemplo02 {
    public @C int[][] a;

    public int @A [][] b;

    public int[] @B [] c;
  }

  public class Exemplo03 {
    public @C int @A [][] a;

    public int @A [] @B [] b;

    public @C int[] @B [] c;
  }

  public class Exemplo04 {
    public @C int @A [] @B [] a;
  }

}