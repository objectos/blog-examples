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
package shared;

import java.io.Closeable;
import java.io.IOException;

public class Resource implements Closeable {
  final String name;

  Resource(String name) {
    this.name = name;

    print0("created");
  }

  public static Resource create(String name) throws IOException {
    return new Resource(name);
  }

  public static Resource throwOnClose(String name) throws IOException {
    return new ThrowOnClose(name);
  }

  public static Resource throwOnCreate(String name) throws IOException {
    throw new IOException("Failed to create: " + name);
  }

  @Override
  public void close() throws IOException {
    print0("closed");
  }

  public void throwOnWrite(String s) throws IOException {
    throw new IOException("Failed to write: " + name);
  }

  public void write(String s) throws IOException {
    print0(s);
  }

  final void print0(String string) {
    System.out.println(name + ": " + string);
  }

  private static class ThrowOnClose extends Resource {
    ThrowOnClose(String name) {
      super(name);
    }

    @Override
    public void close() throws IOException {
      print0("close() called");

      throw new IOException("Failed to close: " + name);
    }
  }
}