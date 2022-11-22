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

public class Example01 {
  public static void main(String[] args) {
    var serializer = new Serializer<>(CityConverter.INSTANCE::convert);

    var sp = new State("SP");

    serializer.addItem(sp.newCity("São Paulo"));
    serializer.addItem(sp.newCity("Guarujá"));

    var rj = new State("RJ");

    serializer.addItem(rj.newCity("Rio de Janeiro"));
    serializer.addItem(rj.newCity("Petrópolis"));

    var result = serializer.toPayload(Payload::<City> new);

    System.out.println(result);
  }
}
