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
import java.util.function.Supplier;

public class Listing10 {
  public static void main(String[] args) {
    var temp1 = new LinkedHashSet<Iterable<Number>>();

    add(temp1, ArrayList::new, 1, 2D, 3L);
    add(temp1, LinkedList::new, (byte) 4, (short) 5, 6D);
    add(temp1, LinkedHashSet::new, 7D, 8F, 7D, 9F, 9F);

    consume(temp1);
  }

  @SafeVarargs
  static <COLL extends Collection<E>, E extends Number> void add(
      Collection<? super COLL> temp1, Supplier<COLL> factory, E... values) {
    COLL coll = factory.get();

    for (var value : values) {
      coll.add(value);
    }

    temp1.add(coll);
  }

  static void consume(Iterable<? extends Iterable<? extends Number>> temp2) {
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