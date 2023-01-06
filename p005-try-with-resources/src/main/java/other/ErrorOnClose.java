/*
 * Copyright (C) 2022-2023 Objectos Software LTDA.
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