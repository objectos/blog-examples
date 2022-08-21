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
package iter5;

import iter5.ConfigValue.IntValue;
import java.util.Map;
import shared.ConfigBuilder;

final class Library {
  private static final int MAX_DEFAULT_VALUE = 256;

  private Library() {}

  public static void defaults(ConfigBuilder... configs) {
    for (var config : configs) {
      config.integer("max", MAX_DEFAULT_VALUE);
    }
  }

  @SafeVarargs
  public static void defaults(Map<String, ConfigValue>... configs) {
    for (var config : configs) {
      config.put("max", new IntValue(MAX_DEFAULT_VALUE));
    }
  }
}