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
package iter1;

import java.util.Objects;

public class CharAt<T extends CharSequence & Comparable<T>>
    implements Comparable<CharAt<T>> {
  private final T cs;

  public CharAt(T cs) {
    this.cs = Objects.requireNonNull(cs);
  }

  public char charAt(int index) { return cs.charAt(index); }

  @Override
  public int compareTo(CharAt<T> o) { return cs.compareTo(o.cs); }

  @Override
  public String toString() { return cs.toString(); }
}