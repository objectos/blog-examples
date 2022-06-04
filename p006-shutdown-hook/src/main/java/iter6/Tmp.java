/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package iter6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Tmp {
  public static void main(String[] args) throws IOException {
    var tmpdir = new Tmpdir();

    var runtime = Runtime.getRuntime();

    runtime.addShutdownHook(new Thread(tmpdir));

    var file = tmpdir.createFile();
    var dir = tmpdir.createDirectory();

    Files.writeString(file, "Hello!\n");

    var child = dir.resolve("child.txt");

    Files.writeString(child, "I am in a directory\n");
  }

  private static class Tmpdir implements Runnable {
    private final List<Path> paths = new ArrayList<>();

    public final Path createDirectory() throws IOException {
      return register(
        Files.createTempDirectory("objectos-blog-")
      );
    }

    public final Path createFile() throws IOException {
      return register(
        Files.createTempFile("objectos-blog-", ".tmp")
      );
    }

    @Override
    public final void run() {
      for (Path p : paths) {
        delete(p);
      }
    }

    protected Path register(Path p) {
      paths.add(p);
      return p;
    }

    private void delete(Path p) {
      try {
        if (Files.isDirectory(p)) {
          deleteContents(p);
        }

        Files.delete(p);
      } catch (IOException e) {
        System.err.println("Failed to delete " + p);
      }
    }

    private void deleteContents(Path dir) throws IOException {
      try (var s = Files.newDirectoryStream(dir)) {
        for (var p : s) {
          delete(p);
        }
      }
    }
  }
}