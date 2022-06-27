/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
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