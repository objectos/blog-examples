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

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class ArtigoBuilder {

  private String titulo;

  private LocalDate data;

  private final Set<String> etiquetas = new TreeSet<>();

  public final Artigo build() {
    Objects.requireNonNull(titulo, "titulo == null");
    Objects.requireNonNull(data, "data == null");

    return new Artigo(titulo, data, etiquetas);
  }

  public ArtigoBuilder titulo(String titulo) {
    this.titulo = Objects.requireNonNull(titulo, "titulo == null");
    return this;
  }

  public ArtigoBuilder data(int ano, int mes, int dia) {
    data = LocalDate.of(ano, mes, dia);
    return this;
  }

  public ArtigoBuilder etiquetas(Iterable<String> valores) {
    for (var valor : valores) {
      Objects.requireNonNull(valor, "valor == null");

      etiquetas.add(valor);
    }

    return this;
  }

}