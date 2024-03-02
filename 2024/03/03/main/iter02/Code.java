/*
 * Copyright (C) 2024 Objectos Software LTDA.
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
package iter02;

import java.util.List;

public class Code extends iter01.Code {
  @Override
  protected final String process0(StringTemplate template, List<String> fragments) {
    Object[] values;
    values = values(template);

    StringBuilder out;
    out = new StringBuilder();

    for (int idx = 0, len = values.length; idx < len; idx++) {
      String fragment;
      fragment = fragments.get(idx);

      out.append(fragment);

      Object value;
      value = values[idx];

      out.append(value);
    }

    String lastFragment;
    lastFragment = fragments.getLast();

    out.append(lastFragment);

    return out.toString();
  }

  protected Object[] values(StringTemplate template) {
    List<Object> values;
    values = template.values();

    return values.toArray();
  }
}
