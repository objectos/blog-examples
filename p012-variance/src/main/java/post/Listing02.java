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

public class Listing02 {
  public static void main(String[] args) {
    var arrayLists = new ArrayList<ArrayList<Integer>>();
    arrayLists.add(New.arrayList(1, 2, 3));
    arrayLists.add(New.arrayList(4, 5, 6));

    printAll(arrayLists);
  }

  private static void printAll(ArrayList<ArrayList<Integer>> all) {
    for (int i = 0, size = all.size(); i < size; i++) {
      ArrayList<Integer> list = all.get(i);

      printOne(list);
    }

    System.out.println();
  }

  private static void printOne(ArrayList<Integer> one) {
    for (int i = 0, size = one.size(); i < size; i++) {
      Integer value = one.get(i);

      int intValue = value.intValue();

      printOneInt(intValue);
    }
  }

  private static void printOneInt(int value) {
    System.out.print(value);
    System.out.print(' ');
  }
}