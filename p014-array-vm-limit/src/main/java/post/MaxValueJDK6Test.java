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

public class MaxValueJDK6Test {
  public static void main(String[] args) {
    Object[] a = new Object[Integer.MAX_VALUE];

    System.out.println("Actual array length=" + a.length);

    a[0] = "first";
    a[Integer.MAX_VALUE - 1] = "last";

    System.out.println(a[0]);
    System.out.println(a[Integer.MAX_VALUE - 1]);

    System.out.println("Test was sucessful");
  }
}
