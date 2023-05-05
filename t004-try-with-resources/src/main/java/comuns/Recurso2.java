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
package comuns;

import java.io.Closeable;
import java.io.IOException;

public class Recurso2 implements Closeable {
  final String name;

  Recurso2(String name) {
    this.name = name;

    print0("criado");
  }

  public static Recurso2 create(String name) throws IOException {
    return new Recurso2(name);
  }

  public static Recurso2 throwOnClose(String name) throws IOException {
    return new ThrowOnClose(name);
  }

  public static Recurso2 throwOnCreate(String name) throws IOException {
    throw new IOException("Não foi possível criar: " + name);
  }

  @Override
  public void close() throws IOException {
    print0("fechado");
  }

  public void throwOnWrite(String s) throws IOException {
    throw new IOException("Não foi possível escrever: " + name);
  }

  public void write(String s) throws IOException {
    print0(s);
  }

  final void print0(String string) {
    System.out.println(name + ": " + string);
  }

  private static class ThrowOnClose extends Recurso2 {
    ThrowOnClose(String name) {
      super(name);
    }

    @Override
    public void close() throws IOException {
      print0("close() chamado");

      throw new IOException("Não foi possível fechar: " + name);
    }
  }
}