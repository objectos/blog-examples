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

public class Listing01 {
  @SuppressWarnings({"unchecked", "rawtypes"})
  public static void main(String[] args) {
    var temp1 = new ArrayList<ArrayList<Integer>>();
    temp1.add(new ArrayList<>());

    List temp2 = temp1;

    temp2.add(new LinkedList<>());

    var arrayList0 = temp1.get(0);
    System.out.println(arrayList0);

    var arrayList1 = temp1.get(1);
    System.out.println(arrayList1);
  }
}