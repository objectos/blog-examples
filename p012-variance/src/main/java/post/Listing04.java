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

public class Listing04 {
  public static void main(String[] args) {
    var temp1 = new ArrayList<ArrayList<Integer>>();

    // 1
    temp1.add(New.arrayList(1, 2, 3));
    temp1.add(New.arrayList(4, 5, 6));
    temp1.add(New.arrayList(7, 8, 9));

    consume(temp1);
  }

  // 2
  private static void consume(ArrayList<ArrayList<Integer>> temp2) {
    for (var value : temp2) {
      printOne(value);
    }

    System.out.println();
  }

  // 3
  private static void printOne(ArrayList<Integer> list) {
    for (var value : list) {
      int intValue = value.intValue();

      printOneInt(intValue);
    }
  }

  // 4
  private static void printOneInt(int value) {
    System.out.print(value);
    System.out.print(" ");
  }
}