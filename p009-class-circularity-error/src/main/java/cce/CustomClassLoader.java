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

  public final Object loadAndCreate(String name) throws Exception {
    var c = loadClass(name);

    var constructor = c.getConstructor();

    return constructor.newInstance();
  }

  public final void put(String name, String payload) {
    data.put(name, payload);
  }

  @Override
  protected final Class<?> findClass(String name) throws ClassNotFoundException {
    var payload = data.get(name);

    if (payload == null) {
      return super.findClass(name);
    } else {
      return load(name, payload);
    }
  }

  private Class<?> load(String name, String payload) {
    var hex = HexFormat.of();

    var bytes = hex.parseHex(payload);

    return defineClass(name, bytes, 0, bytes.length);
  }

}