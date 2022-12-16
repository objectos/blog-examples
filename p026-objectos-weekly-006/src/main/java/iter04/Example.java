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
package iter04;

public class Example {
  public static void main(String[] args) {
    var cities = new Multimap<String, String>();

    cities.put("SP", "São Paulo");
    cities.put("SP", "Guarujá");
    cities.put("SP", "Sorocaba");

    cities.put("SC", null);

    cities.put("PA", "Belém");
    cities.put("PA", "Tomé Açú");

    var entries = cities.entries(NonEmptySet::<String> new);

    System.out.println(entries);
  }
}
