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
    var temp1 = new ArrayList<ArrayList<Integer>>();

    temp1.add(New.arrayList(1, 2, 3));
    temp1.add(New.arrayList(4, 5, 6));
    temp1.add(New.arrayList(7, 8, 9));

    consume(temp1);
  }

  private static void consume(List<? extends List<Integer>> temp2) {
    for (var value : temp2) {
      printOne(value);
    }

    System.out.println();
  }

  private static void printOne(List<Integer> list) {
    for (var value : list) {
      int intValue = value.intValue();

      printOneInt(intValue);
    }
  }

  private static void printOneInt(int value) {
    System.out.print(value);
    System.out.print(' ');
  }
}