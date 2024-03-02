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
package iter03;

import java.util.List;
import java.util.Objects;
import shared.ClassName;
import shared.ImportList;

public class Code extends iter02.Code {

  private final ImportList importList = new ImportList();

  public final ImportList importList(String packageName) {
    Objects.requireNonNull(packageName, "packageName == null");
    importList.set(packageName);
    return importList;
  }

  @Override
  protected final Object[] values(StringTemplate template) {
    List<Object> values;
    values = template.values();

    int size;
    size = values.size();

    Object[] result;
    result = new Object[size];

    for (int idx = 0; idx < size; idx++) {
      Object value;
      value = values.get(idx);

      if (value instanceof ClassName className) {
        value = importList.process(className);
      } else {
        value = processValue(value);
      }

      result[idx] = value;
    }

    return result;
  }

  protected Object processValue(Object value) {
    return value;
  }

}
