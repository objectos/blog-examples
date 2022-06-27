/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package cce;

public class WillItThrow {
  public static void main(String[] args) throws Exception {
    var lookup = new LookupWrapper();

    System.out.println("new ClsCirErr02()");
    lookup.newInstance(Edit.CLASS_02_CIRCULAR);

    System.out.println("new ClsCirErr03()");
    lookup.newInstance(Data.CLASS_03);
  }
}
