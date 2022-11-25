/*
 * Copyright (C) 2022 Objectos Software LTDA.
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
package post;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class TypeAnnotationsExample {

  @Target(ElementType.FIELD)
  @Retention(RetentionPolicy.RUNTIME)
  @interface F {}

  @Target(ElementType.TYPE_USE)
  @Retention(RetentionPolicy.RUNTIME)
  @interface U {}

  @Target({ElementType.FIELD, ElementType.TYPE_USE})
  @Retention(RetentionPolicy.RUNTIME)
  @interface X {}

  private @U volatile @F transient @X int a;

  public static void main(String[] args) throws NoSuchFieldException, SecurityException {
    var exampleClass = TypeAnnotationsExample.class;

    var field = exampleClass.getDeclaredField("a");

    var fieldAnnotations = field.getDeclaredAnnotations();

    System.out.println("Field annotations are:");

    printAnnotations(fieldAnnotations);

    var annotatedType = field.getAnnotatedType();

    System.out.println("Type annotations are:");

    printAnnotations(annotatedType.getDeclaredAnnotations());
  }

  private static void printAnnotations(Annotation[] annotations) {
    for (var annotation : annotations) {
      System.out.println(annotation);
    }
  }

}