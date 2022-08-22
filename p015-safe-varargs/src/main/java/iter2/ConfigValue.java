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
package iter2;

import iter2.ConfigValue.IntValue;
import iter2.ConfigValue.StringValue;

sealed interface ConfigValue permits IntValue, StringValue {

  record IntValue(int value) implements ConfigValue {
    @Override
    public void apply(String key) {
      System.out.format("%s=%d%n", key, value);
    }
  }

  record StringValue(String value) implements ConfigValue {
    @Override
    public void apply(String key) {
      System.out.format("%s=%s%n", key, value);
    }
  }

  void apply(String key);

}