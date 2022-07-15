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

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.util.Objects;

public class FlushThenClose {
  private final Object value;

  public <T extends Flushable & Closeable> FlushThenClose(T value) {
    this.value = Objects.requireNonNull(value);
  }

  public void execute() throws IOException {
    try (var closeable = (Closeable) value) {
      var asFlushable = (Flushable) value;

      asFlushable.flush();
    }
  }
}