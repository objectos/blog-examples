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
package jep447;

import java.util.Objects;

public class GitObjectId {

  private final byte[] value;

  public GitObjectId(byte[] value) {
    this.value = Objects.requireNonNull(value, "value == null");

    if (this.value.length != 20) {
      throw new IllegalArgumentException();
    }
  }

  public GitObjectId(String sha1) {
    this(parse(sha1));
  }

  private static byte[] parse(String sha1) throws IllegalArgumentException {
    return null;
  }

}