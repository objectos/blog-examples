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
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.AnnotatedArrayType;

public class Item03 {

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE_USE)
  @interface A {}

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE_USE)
  @interface B {}

  @Retention(RetentionPolicy.RUNTIME)
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

  public static class Exemplo05 {
    public @C int @A [] @B [] a;
  }

  public static void main(String[] args) throws NoSuchFieldException, SecurityException {
    int[][] array = {
        {1, 2, 3, 4, 5},
        {6, 7, 8, 9}
    };

    int[][] tipo01 = array;
    int[] tipo02 = tipo01[1];
    int tipo03 = tipo02[3];

    System.out.println(tipo03);

    var field = Exemplo05.class.getField("a");

    var type01 = (AnnotatedArrayType) field.getAnnotatedType();

    System.out.println(type01);

    for (var anno : type01.getAnnotations()) {
      System.out.println(anno);
    }

    var type02 = (AnnotatedArrayType) type01.getAnnotatedGenericComponentType();

    System.out.println(type02);

    for (var anno : type02.getAnnotations()) {
      System.out.println(anno);
    }

    var type03 = type02.getAnnotatedGenericComponentType();

    System.out.println(type03);

    for (var anno : type03.getAnnotations()) {
      System.out.println(anno);
    }
  }

}