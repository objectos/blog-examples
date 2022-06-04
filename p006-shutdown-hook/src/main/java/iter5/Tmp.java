/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package iter5;

import java.io.IOException;
import java.nio.file.Files;

public class Tmp {
  public static void main(String[] args) throws IOException {
    var file = Files.createTempFile("objectos-blog-", ".tmp");
    var dir = Files.createTempDirectory("objectos-blog-");

    file.toFile().deleteOnExit();
    dir.toFile().deleteOnExit();

    Files.writeString(file, "Hello!\n");

    var child = dir.resolve("child.txt");

    Files.writeString(child, "I am in a directory\n");
  }
}