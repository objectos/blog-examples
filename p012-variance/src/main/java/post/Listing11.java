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
import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;

public class Listing11 {
  @SuppressWarnings("serial")
  private static class ThisArrayList<E> extends ArrayList<E> {
  }

  public static void main(String[] args) {
    var lists = new ArrayList<List<Number>>();

    addNew(lists, ArrayList::new, 1, 2, 3);
    addNew(lists, LinkedList::new, 4D, 5D, 6D);
    addNew(lists, ThisArrayList::new, 7L, 8L, 9L);

    printAll(lists);
  }

  @SafeVarargs
  private static <E extends Number> void addNew(
      List<? super List<E>> lists, Supplier<List<E>> factory, E... values) {
    var list = factory.get();

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