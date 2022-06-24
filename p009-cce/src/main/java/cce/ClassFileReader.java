/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package cce;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HexFormat;

public class ClassFileReader {
  public static void main(String[] args) throws IOException {
    print("ClsCircErr01");
    print("ClsCircErr02");
    print("ClsCircErr03");
    print("LangObjtOnly");
  }

  private static void print(String name) throws IOException {
    System.out.println(name);

    byte[] bytes = readBytes(name);

    printBytes(bytes);
  }

  private static void printBytes(byte[] bytes) {
    var col = 80;

    var hex = HexFormat.of();

    var str = hex.formatHex(bytes);

    int len = str.length();

    int rows = (len / col) + 1;

    for (int row = 0; row < rows; row++) {
      int from = row * col;

      int to = from + col;

      to = Math.min(to, len);

      System.out.println(str.substring(from, to));
    }
  }

  private static byte[] readBytes(String simpleName) throws IOException {
    var self = ClassFileReader.class;

    var out = new ByteArrayOutputStream();

    try (var in = self.getResourceAsStream(simpleName + ".class")) {
      in.transferTo(out);
    }

    return out.toByteArray();
  }

}