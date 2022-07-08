/*
 * Copyright (C) 2022 Objectos Software LTDA.
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
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HexFormat;
import org.testng.annotations.Test;

public class BlobReaderTest {
  private static final String README = //
      """
      78013dcb310a80300c4661e79ee20707b782a377105cbc40532356aa9126\
      d2ebeba2f3fb1e65210c7dd362ba0b8cd57015d9399a73f3961435e50c62\
      c897e93dbc1bd93a853223ada88c184e140e0b92612d72fcdebb07525820\
      c6\
      """;

  @Test
  public void readme() throws IOException {
    var hexFormat = HexFormat.of();

    var bytes = hexFormat.parseHex(README);

    try (var inputStream = new ByteArrayInputStream(bytes)) {
      var reader = new BlobReader();

      var blob = reader.readInputStream(inputStream);

      assertEquals(
        blob.text(),

        """
        # Our test project

        This will be our test blob.
        Let's see if we can read it from our test.
        """
      );
    }
  }

  @Test
  public void readmeWithFile() throws IOException {
    var hexFormat = HexFormat.of();

    var bytes = hexFormat.parseHex(README);

    var file = File.createTempFile("blob-", ".tmp");

    file.deleteOnExit();

    try (var out = new FileOutputStream(file)) {
      out.write(bytes);
    }

    var reader = new BlobReader();

    var blob = reader.readFile(file);

    assertEquals(
      blob.text(),

      """
      # Our test project

      This will be our test blob.
      Let's see if we can read it from our test.
      """
    );
  }

}