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

import java.util.ArrayList;

public class Blog01 {
  public static void main(String[] args) {
    var etiquetas = new ArrayList<String>();

    etiquetas.add("java");
    etiquetas.add("algoritmos");
    etiquetas.add("java");
    etiquetas.add("programação");

    var artigo = new ArtigoBuilder()
        .titulo("Exemplo 01")
        .data(2023, 5, 5)
        .etiquetas(etiquetas)
        .build();

    System.out.println(artigo);
  }
}