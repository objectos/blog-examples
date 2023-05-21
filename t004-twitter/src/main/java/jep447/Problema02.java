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
package jep447;

import java.util.ArrayList;
import java.util.List;

public class Problema02 {

  public static class Super {
    final List<Integer> values;

    public Super() {
      values = new ArrayList<>();
      values.add(1);
      values.add(2);
      values.add(3);
    }

    /**
     * @return os números 1, 2 e 3 em ordem.
     */
    public List<Integer> umDoisTres() {
      return List.copyOf(values);
    }
  }

  public static class Sub extends Super {
    public Sub() {
      //values = new ArrayList<>();
      values.add(7);
      values.add(8);
      values.add(9);

      // super();
    }
  }

}