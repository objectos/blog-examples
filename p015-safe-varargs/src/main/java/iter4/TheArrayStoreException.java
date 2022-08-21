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

public class TheArrayStoreException {
  public static void main(String[] args) {
    Object[] a = new String[2];

    var c = a.getClass();
    if (c.isArray()) {
      var componentType = c.getComponentType();

      System.out.println("Component type is " + componentType);
    }

    System.out.println("Index 0");
    a[0] = "abc";
    System.out.println("Index 1");
    a[1] = 123;
  }
}