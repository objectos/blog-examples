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
package binary;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.zip.InflaterInputStream;

public class BlobReader {
  public final Blob readFile(File file) throws IOException {
    try (var inputStream = new FileInputStream(file)) {
      return readInputStream(inputStream);
    }
  }

  public final Blob readInputStream(InputStream inputStream) throws IOException {
    try (var out = new ByteArrayOutputStream()) {
      var in = new InflaterInputStream(inputStream);

      in.transferTo(out);

      var bytes = out.toByteArray();

      if (bytes.length < 5) {
        throw new IOException("No header");
      }

      int i = 0;

      var matches = true
          && bytes[i++] == 0x62 // b
          && bytes[i++] == 0x6c // l
          && bytes[i++] == 0x6f // o
          && bytes[i++] == 0x62 // b
          && bytes[i++] == 0x20; // SPACE

      if (!matches) {
        throw new IOException("Not a valid blob.");
      }

      int size = 0;

      var found = false;

      while (i < bytes.length) {
        var b = bytes[i++];

        if (b == 0) {
          found = true;

          break;
        }

        if (b < 48 && b > 57) {
          throw new IOException("Not a digit");
        }

        size *= 10;

        size += (b - 48);
      }

      if (!found) {
        throw new IOException("Did not find size information");
      }

      if (bytes.length != i + size) {
        throw new IOException("Invalid size information");
      }

      byte[] data = Arrays.copyOfRange(bytes, i, bytes.length);

      return new Blob(data);
    }
  }
}