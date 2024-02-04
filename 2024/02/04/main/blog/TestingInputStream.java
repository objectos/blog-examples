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
package blog;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class TestingInputStream extends InputStream {

  private final Object[] data;

  private int index;

  private IOException closeError;

  public TestingInputStream(Object... data) {
    this.data = data.clone();
  }

  public final void onClose(IOException error) {
    closeError = error;
  }

  @Override
  public final int read() throws IOException {
    throw new UnsupportedOperationException(
        "Please use the read(byte[], int, int) method"
    );
  }

  @Override
  public final int read(byte[] b, int off, int len) throws IOException {
    if (index == data.length) {
      return -1;
    }

    Object next;
    next = data[index++];

    if (next instanceof String s) {
      next = s.getBytes(StandardCharsets.UTF_8);
    }

    if (next instanceof byte[] bytes) {
      int lengthToCopy;
      lengthToCopy = bytes.length;

      if (lengthToCopy > len) {
        int lengthRemaining;
        lengthRemaining = lengthToCopy - len;

        byte[] remaining;
        remaining = new byte[lengthRemaining];

        System.arraycopy(bytes, len, remaining, 0, lengthRemaining);

        data[--index] = remaining;

        lengthToCopy = len;
      }

      System.arraycopy(bytes, 0, b, off, lengthToCopy);

      return lengthToCopy;
    }

    else if (next instanceof IOException ioe) {
      throw ioe;
    }

    else {
      throw new UnsupportedOperationException(
          "Implement me :: type=" + next.getClass()
      );
    }
  }

  @Override
  public final void close() throws IOException {
    if (closeError != null) {
      throw closeError;
    }
  }

}