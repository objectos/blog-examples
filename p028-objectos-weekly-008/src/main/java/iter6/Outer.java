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
package iter6;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

public class Outer {
  // @formatter:off
  @Target(ElementType.TYPE_USE) public @interface X {}

  @Target(ElementType.TYPE_USE) public @interface Y {}

  @Target(ElementType.TYPE_USE) public @interface Z {}
  // @formatter:on

  class Inner {
    final Outer outer;

    Inner(@X @Y @Z Outer Outer.this) {
      outer = Outer.this;
    }
  }
}