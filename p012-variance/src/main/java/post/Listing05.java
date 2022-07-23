/*
 * Copyright (C) 2022 Objectos Software LTDA.
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
import java.util.List;

public class Listing05 {
  public static void main(String[] args) {
    var lists = new ArrayList<List<Integer>>();

    addNewArrayList(lists, 1, 2, 3);
    addNewArrayList(lists, 4, 5, 6);
    addNewArrayList(lists, 7, 8, 9);

    printAll(lists);
  }

  private static void addNewArrayList(ArrayList<List<Integer>> lists, Integer... values) {
    var list = new ArrayList<Integer>();

    for (var value : values) {
      list.add(value);
    }

    lists.add(list);
  }

  private static void printAll(List<? extends List<? extends Number>> all) {
    for (int i = 0, size = all.size(); i < size; i++) {
      List<? extends Number> list = all.get(i);

      printOne(list);
    }

    System.out.println();
  }

  private static void printOne(List<? extends Number> one) {
    for (int i = 0, size = one.size(); i < size; i++) {
      Number value = one.get(i);

      int intValue = value.intValue();

      printOneInt(intValue);
    }
  }

  private static void printOneInt(int value) {
    System.out.print(value);
    System.out.print(' ');
  }
}