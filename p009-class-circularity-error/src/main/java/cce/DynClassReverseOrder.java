/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package cce;

import java.lang.invoke.MethodHandles;

public class DynClassReverseOrder {
  public static void main(String[] args) throws Exception {
    var lookup = MethodHandles.lookup();

    System.out.println("Will create ClsCirErr03");

    DynClass.defineAndCreate(lookup, Data.CLASS_03);

    System.out.println("Will create ClsCirErr02");

    DynClass.defineAndCreate(lookup, Data.CLASS_02);

    System.out.println("Will create ClsCirErr01");

    DynClass.defineAndCreate(lookup, Data.CLASS_01);
  }
}