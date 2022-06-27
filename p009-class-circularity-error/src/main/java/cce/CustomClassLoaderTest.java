/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package cce;

public class CustomClassLoaderTest {
  public static void main(String[] args) throws Exception {
    var ourLoader = new CustomClassLoader();

    ourLoader.put("cce.ClsCircErr01", Data.CLASS_01);
    ourLoader.put("cce.ClsCircErr02", Data.CLASS_02);
    ourLoader.put("cce.ClsCircErr03", Data.CLASS_03);

    System.out.println("new ClsCirErr03()");
    ourLoader.newInstance("cce.ClsCircErr03");
  }
}