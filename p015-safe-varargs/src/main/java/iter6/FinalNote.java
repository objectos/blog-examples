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
package iter6;

import java.util.Arrays;
import java.util.List;

public class FinalNote {
  @SuppressWarnings("unchecked")
  public static void main(String[] args) {
    List<String>[] generic = genericArray(
      Arrays.asList("A", "B", "C"),
      Arrays.asList("D", "E", "F"));

    Object[] alias = generic;

    alias[0] = Arrays.asList(1, 2, 3);

    String a = generic[0].get(0);
    System.out.println(a);
  }

  // not safe!!!
  @SuppressWarnings("unchecked")
  private static <T> T[] genericArray(T... values) {
    return values;
  }
}