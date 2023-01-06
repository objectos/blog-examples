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
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class Listing10d {
  public static void main(String[] args) {
    var temp1 = new HashSet<Collection<Double>>();

    Listing10.add(temp1, HashSet::new, 1D, 2D, 2D, 3D, 3D);
    Listing10.add(temp1, ArrayList::new, 4D, 5D, 6D);
    Listing10.add(temp1, LinkedHashSet::new, 7D, 8D, 7D, 9D);

    Listing10.consume(temp1);
  }
}