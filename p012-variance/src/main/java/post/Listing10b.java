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
import java.util.Vector;

public class Listing10b {
  public static void main(String[] args) {
    var temp1 = new ArrayList<List<Integer>>();

    Listing10.add(temp1, ArrayList::new, 1, 2, 3);
    Listing10.add(temp1, LinkedList::new, 4, 5, 6);
    Listing10.add(temp1, Vector::new, 7, 8, 9);

    Listing10.consume(temp1);
  }
}