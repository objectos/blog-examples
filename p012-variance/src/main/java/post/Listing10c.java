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

import java.util.HashSet;
import java.util.Set;

public class Listing10c {
  public static void main(String[] args) {
    var temp1 = new HashSet<Set<Number>>();

    Listing10.add(temp1, HashSet::new, 1, 2, 2, 3, 3);
    Listing10.add(temp1, HashSet::new, 4, 5, 6, 6);
    Listing10.add(temp1, HashSet::new, 7L, 8L, 9L);

    Listing10.consume(temp1);
  }
}