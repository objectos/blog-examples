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
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;

public class Listing10 {
  public static void main(String[] args) {
    var temp1 = new ArrayList<Iterable<Number>>();

    add(temp1, ArrayList::new, 1, 2, 3);
    add(temp1, LinkedList::new, 4D, 5D, 6D);
    add(temp1, LinkedHashSet::new, 7L, 8L, 9L);

    consume(temp1);
  }

  @SafeVarargs
  private static <E extends Number> void add(
      List<? super Iterable<E>> temp1, Supplier<Collection<E>> factory, E... values) {
    var coll = factory.get();

    for (var value : values) {
      coll.add(value);
    }

    temp1.add(coll);
  }

  private static void consume(Iterable<? extends Iterable<? extends Number>> temp2) {
    for (Iterable<? extends Number> value : temp2) {
      printOne(value);
    }

    System.out.println();
  }

  private static void printOne(Iterable<? extends Number> one) {
    for (Number value : one) {
      int intValue = value.intValue();

      printOneInt(intValue);
    }
  }

  private static void printOneInt(int value) {
    System.out.print(value);
    System.out.print(' ');
  }
}