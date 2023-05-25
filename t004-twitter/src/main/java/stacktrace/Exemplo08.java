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
package stacktrace;

public class Exemplo08 {
  public static void main(String[] args) {
    new Exemplo08().a();
  }

  public void a() {
    b();
  }

  public void b() {
    c();
  }

  public void c() {
    throw new RuntimeException(
      "Fui lançada do método c()"
    );
  }
}
