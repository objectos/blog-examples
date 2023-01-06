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
package iter03;

import java.lang.System.Logger.Level;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class Example {
  public static void main(String[] args) {
    BiFunction<Function<Log, String>, Log, Payload> constructor;
    constructor = Payload::<Log> new;

    Function<Log, String> converter;
    converter = new LogConverter()::convert;

    Consumer<Log> emitter;
    emitter = (log) -> {
      var payload = constructor.apply(converter, log);

      System.out.println(payload);
    };

    emitter.accept(new Log(111L, Level.INFO, "Hello world!"));
    emitter.accept(new Log(222L, Level.ERROR, "Uh-oh"));
  }
}
