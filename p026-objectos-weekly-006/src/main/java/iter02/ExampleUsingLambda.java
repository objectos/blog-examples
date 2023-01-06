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
package iter02;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import objectos.util.GrowableList;

public class ExampleUsingLambda {
  public static void main(String[] args) {
    var cityNames = List.of(
      "São Paulo", "Belém", "Rio de Janeiro");

    Function<String, City> f;
    f = (cityName) -> new City(cityName);

    // Function<String, City> f;
    // f = City::new;

    var cities = cityNames.stream()
        .map(f)
        .collect(Collectors.toCollection(GrowableList::new));

    System.out.println(cities);
  }
}