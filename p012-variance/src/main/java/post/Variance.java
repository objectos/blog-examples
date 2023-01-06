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
import java.util.List;
import java.util.Set;

public class Variance {
  @SuppressWarnings("unused")
  static void contravariance() {
    Collection<? super ArrayList<Number>> temp1
        = new LinkedHashSet<Iterable<Number>>();
  }

  @SuppressWarnings("unused")
  static void covariance() {
    Iterable<? extends Iterable<? extends Number>> a
        = new ArrayList<ArrayList<Integer>>();

    Iterable<? extends Iterable<? extends Number>> b
        = new ArrayList<List<Integer>>();

    Iterable<? extends Iterable<? extends Number>> c
        = new HashSet<Collection<Double>>();

    Iterable<? extends Iterable<? extends Number>> d
        = new LinkedHashSet<Iterable<Number>>();

    Iterable<? extends Iterable<? extends Number>> e
        = new HashSet<Set<Number>>();

    a = b = c = d = e;
    e = d = c = b = a;
  }
}