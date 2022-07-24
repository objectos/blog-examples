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

public class Listing11 {
  @SuppressWarnings("unused")
  static void consume(List<? extends Number> temp2) {
    // only 'read' the type variable
    Number number = temp2.get(0);
    Iterator<? extends Number> iterator = temp2.iterator();

    // takes an non-parameterized argument: OK
    Number removed = temp2.remove(0);

    // non-parameterized method: also OK
    int size = temp2.size();
  }

  //  static void invalid(List<? extends Number> temp2) {
  //    // tries to 'write' to the type variable: not OK
  //    temp2.add(1D);
  //    temp2.set(0, 123L);
  //    temp2.addAll(List.of(1, 2, 3));
  //  }
}