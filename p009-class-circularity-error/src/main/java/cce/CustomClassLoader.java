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

import java.util.HashMap;
import java.util.HexFormat;
import java.util.Map;

final class CustomClassLoader extends ClassLoader {
  private final Map<String, String> data = new HashMap<>();

  public final Object newInstance(String name) throws Exception {
    var c = loadClass(name);

    var constructor = c.getConstructor();

    return constructor.newInstance();
  }

  public final void put(String name, String hexdump) {
    data.put(name, hexdump);
  }

  @Override
  protected final Class<?> findClass(String name) throws ClassNotFoundException {
    var hexdump = data.get(name);

    if (hexdump == null) {
      return super.findClass(name);
    } else {
      return load(name, hexdump);
    }
  }

  private Class<?> load(String name, String hexdump) {
    var hex = HexFormat.of();

    var bytes = hex.parseHex(hexdump);

    return defineClass(name, bytes, 0, bytes.length);
  }
}