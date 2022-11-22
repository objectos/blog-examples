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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import objectos.util.GrowableList;

public class Serializer<T> {
  private final Function<T, String> converter;

  private final List<T> items = new ArrayList<>();

  public Serializer(Function<T, String> converter) {
    this.converter = converter;
  }

  public final void addItem(T item) {
    Objects.requireNonNull(item, "item == null");

    items.add(item);
  }

  public final List<Payload> toPayload(
      BiFunction<Function<T, String>, T, Payload> function) {
    return items.stream()
        .map(e -> function.apply(converter, e))
        .collect(Collectors.toCollection(GrowableList::new));
  }
}