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
package iter3;

import iter3.ConfigValue.IntValue;
import iter3.ConfigValue.StringValue;
import java.util.HashMap;
import java.util.Map;

public class Server {
  @SuppressWarnings("unchecked")
  public static void main(String[] args) {
    var serviceA = new HashMap<String, ConfigValue>();
    serviceA.put("name", new StringValue("Service A"));

    var serviceB = new HashMap<String, ConfigValue>();
    serviceB.put("name", new StringValue("Service B"));

    Library.defaults(serviceA, serviceB);

    serviceB.put("max", new IntValue(512));

    start(serviceA);
    start(serviceB);
  }

  private static void start(Map<String, ConfigValue> config) {
    System.out.println("Starting...");

    for (var entry : config.entrySet()) {
      var key = entry.getKey();
      var value = entry.getValue();
      value.apply(key);
    }

    System.out.println();
  }
}