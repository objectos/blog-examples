/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package cce;

public class ReplaceSuperclass {
  public static void main(String[] args) throws Exception {
    var lookup = new LookupWrapper();

    System.out.println("new ClsCirErr02()");
    lookup.newInstance(Edit.CLASS_02_OBJECT);
  }
}