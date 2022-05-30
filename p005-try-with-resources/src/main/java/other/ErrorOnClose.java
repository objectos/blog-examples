/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package other;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class ErrorOnClose {
  public static void main(String[] args) throws IOException, InterruptedException {
    // /tmp/io is a tmpfs with 4k of space
    var file = Path.of("/tmp/io/test.txt");

    try (var o = Files.newOutputStream(file); var w = new BufferedOutputStream(o)) {
      var b = new byte[7000];
      Arrays.fill(b, (byte) 34);
      w.write(b);
      System.out.println("will close");
    }
  }
}