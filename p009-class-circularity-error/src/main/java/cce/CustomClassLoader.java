/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
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