/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package cce;

public class TryWithCustomClassLoader {
  public static void main(String[] args) throws Exception {
    var ourLoader = new CustomClassLoader();

    ourLoader.put("cce.ClsCircErr02", Data.MOD_CLASS_02);
    ourLoader.put("cce.ClsCircErr03", Data.CLASS_03);

    ourLoader.loadAndCreate("cce.ClsCircErr03");
  }
}