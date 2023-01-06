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

import static org.testng.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HexFormat;
import java.util.zip.DeflaterOutputStream;
import org.testng.annotations.Test;

public class UncompressedTest {
  private static final String README = """
      626c6f6220393100\
      3d\
      204f757220746573742070726f6a6563740a0a5468\
      69732077696c6c206265206f7572207465737420626c6f622e0a4c657427\
      73207365652069662077652063616e20726561642069742066726f6d206f\
      757220746573742e0a\
      """;

  @Test
  public void readme() throws IOException {
    var out = new ByteArrayOutputStream();

    try (var outputStream = new DeflaterOutputStream(out)) {
      var hexFormat = HexFormat.of();

      outputStream.write(hexFormat.parseHex(README));
    }

    var bytes = out.toByteArray();

    try (var inputStream = new ByteArrayInputStream(bytes)) {
      var reader = new BlobReader();

      var blob = reader.readInputStream(inputStream);

      assertEquals(
        blob.text(),

        """
        = Our test project

        This will be our test blob.
        Let's see if we can read it from our test.
        """
      );
    }
  }
}