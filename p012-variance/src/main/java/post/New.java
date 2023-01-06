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
package post;

import java.util.ArrayList;
import java.util.LinkedList;

final class New {

  private New() {}

  public static ArrayList<Integer> arrayList(int... values) {
    var list = new ArrayList<Integer>();

    for (int value : values) {
      list.add(value);
    }

    return list;
  }

  public static LinkedList<Integer> linkedList(int... values) {
    var list = new LinkedList<Integer>();

    for (int value : values) {
      list.add(value);
    }

    return list;
  }

}