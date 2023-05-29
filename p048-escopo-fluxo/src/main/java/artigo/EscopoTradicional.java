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
import java.util.List;
import java.util.concurrent.Future;

public class EscopoTradicional {

  public interface Foo {}

  public void instrucaoFor(List<String> elements) {
    var result = new ArrayList<Future<Foo>>();

    for (var element : elements) {
      var future = submit(element);

      result.add(future);
    }

    // erro de compilação
    // System.out.println(element);
  }

  private Future<Foo> submit(String element) { return null; }

}