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
package cce;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;
import java.util.HexFormat;

class LookupWrapper {
  private final Lookup lookup = MethodHandles.lookup();

  public Object newInstance(String s) throws Exception {
    var hexFormat = HexFormat.of();

    var bytes = hexFormat.parseHex(s);

    var c = lookup.defineClass(bytes);

    var constructor = c.getConstructor();

    return constructor.newInstance();
  }
}