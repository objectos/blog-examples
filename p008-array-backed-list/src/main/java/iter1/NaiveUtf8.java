/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package iter1;

import java.nio.charset.StandardCharsets;

public class NaiveUtf8 {
  public static void main(String[] args) {
    var bytes = "ABC".getBytes(StandardCharsets.UTF_8);

    var abc = new Utf8(bytes);

    System.out.println(abc);

    bytes[0] = 0x31;
    bytes[1] = 0x32;
    bytes[2] = 0x33;

    System.out.println(abc);
  }

  static class Utf8 {
    final byte[] bytes;

    Utf8(byte[] bytes) {
      this.bytes = bytes;
    }

    @Override
    public String toString() {
      return new String(bytes, StandardCharsets.UTF_8);
    }
  }
}