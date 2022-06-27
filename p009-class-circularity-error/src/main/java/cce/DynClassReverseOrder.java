/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package cce;

public class DynClassReverseOrder {
  public static void main(String[] args) throws Exception {
    var lookup = new LookupWrapper();

    System.out.println("new ClsCirErr03()");
    lookup.newInstance(Data.CLASS_03);

    System.out.println("new ClsCirErr02()");
    lookup.newInstance(Data.CLASS_02);

    System.out.println("new ClsCirErr01()");
    lookup.newInstance(Data.CLASS_01);
  }
}