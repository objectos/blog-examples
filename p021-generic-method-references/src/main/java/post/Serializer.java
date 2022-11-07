/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
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