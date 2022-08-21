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
package iter4;

import java.util.ArrayList;
import java.util.List;

public class TheArrayStoreExceptionCounter {
  @SuppressWarnings({"rawtypes", "unchecked"})
  public static void main(String[] args) {
    List a = new ArrayList<String>(2);

    var c = a.getClass();
    var typeParameters = c.getTypeParameters();
    for (var typeVar : typeParameters) {
      System.out.println(typeVar);
    }

    System.out.println("Index 0");
    a.add("abc");

    System.out.println("Index 1");
    a.add(123);
  }
}