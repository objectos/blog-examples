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

import java.util.Iterator;
import java.util.List;

public class Listing12 {
  static void add(List<? super Number> temp1) {
    // 'writing' to the type variable: OK
    temp1.add(1D);
    temp1.set(0, 123L);
    temp1.addAll(List.of(1, 2, 3));
  }

  @SuppressWarnings("unused")
  static void read(List<? super Number> temp1) {
    // 'reading' the type variable: java.lang.Object
    Object value = temp1.get(0);
    Iterator<? super Number> iterator = temp1.iterator();
    Object next = iterator.next();
  }
}