/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package cce;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;
import java.util.HexFormat;

public class DynClass {
  public static void main(String[] args) throws Exception {
    var lookup = MethodHandles.lookup();

    System.out.println("Will create ClsCirErr01");

    defineAndCreate(lookup, Data.CLASS_01);

    System.out.println("Will create ClsCirErr02");

    defineAndCreate(lookup, Data.CLASS_02);

    System.out.println("Will create ClsCirErr03");

    defineAndCreate(lookup, Data.CLASS_03);
  }

  static Class<?> define(Lookup lookup, String payload) throws IllegalAccessException {
    var hex = HexFormat.of();

    var bytes = hex.parseHex(payload);

    return lookup.defineClass(bytes);
  }

  static Object defineAndCreate(Lookup lookup, String payload) throws Exception {
    var c = define(lookup, payload);

    var constructor = c.getConstructor();

    return constructor.newInstance();
  }
}