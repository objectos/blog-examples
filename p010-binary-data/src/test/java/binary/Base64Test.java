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
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import org.testng.annotations.Test;

public class Base64Test {
  private static final String README = """
      eAE9yzEKgDAMRmHnnuIHB7eCo3cQXLxAUyNWqpEm0uvrovP7HmUhDH3TYroLjNVwFdk5mnPzlhQ1
      5QxiyJfpPbwb2TqFMiOtqIwYThQOC5JhLXL83rsHUlggxg==
      """;

  @Test
  public void readme() throws IOException {
    var decoder = Base64.getMimeDecoder();

    var bytes = decoder.decode(README);

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
    var decoder = Base64.getMimeDecoder();

    var bytes = decoder.decode(README);

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