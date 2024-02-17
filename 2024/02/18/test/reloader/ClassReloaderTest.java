/*
 * Copyright (C) 2024 Objectos Software LTDA.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package reloader;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HexFormat;
import org.testng.annotations.Test;

public class ClassReloaderTest {

  private static final String ORIGINAL = """
  cafebabe0000004100110a000200030700040c000500060100106a617661\
  2f6c616e672f4f626a6563740100063c696e69743e010003282956080008\
  01001149276d20746865206f726967696e616c2107000a01001072656c6f\
  616465722f5375626a656374010004436f646501000f4c696e654e756d62\
  65725461626c65010008746f537472696e6701001428294c6a6176612f6c\
  616e672f537472696e673b01000a536f7572636546696c6501000c537562\
  6a6563742e6a617661002100090002000000000002000100050006000100\
  0b0000001d00010001000000052ab70001b100000001000c000000060001\
  000000030011000d000e0001000b0000001b00010001000000031207b000\
  000001000c000000060001000000060001000f000000020010\
  """;

  private static final String UPDATED = """
  cafebabe0000004100110a000200030700040c000500060100106a617661\
  2f6c616e672f4f626a6563740100063c696e69743e010003282956080008\
  01001552656c6f6164696e67207375636365737366756c2107000a010010\
  72656c6f616465722f5375626a656374010004436f646501000f4c696e65\
  4e756d6265725461626c65010008746f537472696e6701001428294c6a61\
  76612f6c616e672f537472696e673b01000a536f7572636546696c650100\
  0c5375626a6563742e6a6176610021000900020000000000020001000500\
  060001000b0000001d00010001000000052ab70001b100000001000c0000\
  00060001000000030011000d000e0001000b0000001b0001000100000003\
  1207b000000001000c000000060001000000060001000f000000020010\
  """;

  @Test(description = """
  It should be able to load and reload the subject class.
  """)
  public void testCase01() throws Exception {
    Path classOutput;
    classOutput = Files.createTempDirectory("reloader-");

    ClassReloader reloader;
    reloader = new ClassReloader(classOutput);

    try {
      Path packageDir;
      packageDir = classOutput.resolve("reloader");

      Files.createDirectories(packageDir);

      Path classFile;
      classFile = packageDir.resolve("Subject.class");

      HexFormat hexFormat;
      hexFormat = HexFormat.of();

      Files.write(classFile, hexFormat.parseHex(ORIGINAL));

      assertEquals(execute(reloader), "I'm the original!");

      Files.write(classFile, hexFormat.parseHex(UPDATED));

      assertEquals(execute(reloader), "Reloading successful!");
    } finally {
      deleteRecursively(classOutput);
    }
  }

  private String execute(ClassReloader reloader) throws Exception {
    Class<?> clazz;
    clazz = reloader.loadClass("reloader.Subject");

    Constructor<?> constructor;
    constructor = clazz.getConstructor();

    Object instance;
    instance = constructor.newInstance();

    return instance.toString();
  }

  private void deleteRecursively(Path directory) throws IOException {
    SimpleFileVisitor<Path> rm;
    rm = new SimpleFileVisitor<Path>() {
      @Override
      public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        Files.delete(dir);
        return FileVisitResult.CONTINUE;
      }

      @Override
      public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Files.delete(file);
        return FileVisitResult.CONTINUE;
      }
    };

    Files.walkFileTree(directory, rm);
  }

}