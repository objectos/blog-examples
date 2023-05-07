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

import java.util.Arrays;

public class Objectos {

  public Objectos() {}

  public final int[] parse(String s) {
    var result = new int[20];
    var resultIndex = 0;
    var sb = new StringBuilder();

    for (int i = 0, len = s.length(); i < len; i++) {
      char c = s.charAt(i);

      if (Character.isDigit(c)) {
        sb.append(c);

        continue;
      }

      if (sb.isEmpty()) {
        continue;
      }

      result[resultIndex++] = Integer.parseInt(sb.toString());

      sb.setLength(0);
    }

    if (!sb.isEmpty()) {
      result[resultIndex++] = Integer.parseInt(sb.toString());

      sb.setLength(0);
    }

    return Arrays.copyOf(result, resultIndex);
  }

}