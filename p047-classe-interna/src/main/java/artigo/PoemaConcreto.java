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
package artigo;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PoemaConcreto implements Iterable<String> {
  private final String[] versos = {
      "No meio do caminho tinha uma pedra",
      "tinha uma pedra no meio do caminho",
      "tinha uma pedra",
      "no meio do caminho tinha uma pedra."
  };

  public static void main(String[] args) {
    var poema = new PoemaConcreto();

    for (var verso : poema) {
      System.out.println(verso);
    }
  }

  @Override
  public Iterator<String> iterator() {
    return this.new IteratorImpl();
  }

  private class IteratorImpl implements Iterator<String> {
    private int index;

    @Override
    public boolean hasNext() {
      return index < versos.length;
    }

    @Override
    public String next() {
      if (hasNext()) {
        return versos[index++];
      } else {
        throw new NoSuchElementException();
      }
    }
  }
}