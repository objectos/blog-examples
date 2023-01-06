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
package iter01;

import java.util.Objects;
import java.util.Set;

public class NonEmptySet {
  private final Object defaultValue;
  private final Set<?> set;

  public NonEmptySet(String defaultValue) {
    <String> this(defaultValue, Set.of());
  }

  public <T> NonEmptySet(T defaultValue, Set<T> set) {
    this.defaultValue = Objects.requireNonNull(defaultValue);
    this.set = Objects.requireNonNull(set);
  }

  @Override
  public String toString() {
    return set.isEmpty()
        ? "[" + defaultValue.toString() + "]"
        : set.toString();
  }
}