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

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 3, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 3, time = 1, timeUnit = TimeUnit.SECONDS)
public class Switch {

  int[] lookup;

  int[] table;

  int x = 123;

  @Setup
  public void _shuffle() {
    lookup = new int[] {
        1, 5, 10, 50, 100,

        500, 1000, 5000, 10000, 50000
    };

    Collections.shuffle(Arrays.asList(lookup));

    table = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    Collections.shuffle(Arrays.asList(table));
  }

  @Benchmark
  public int lookupSwitch() {
    var result = 0;

    for (int i = 0; i < lookup.length; i++) {
      var state = lookup[i];

      result += switch (state) {
        case 1 -> compute(1001);
        case 5 -> compute(1002);
        case 10 -> compute(1003);
        case 50 -> compute(1004);
        case 100 -> compute(1005);
        case 500 -> compute(1006);
        case 1000 -> compute(1007);
        case 5000 -> compute(1008);
        case 10000 -> compute(1009);
        case 50000 -> compute(1010);
        default -> 0;
      };
    }

    return result;
  }

  @Benchmark
  public int tableSwitch() {
    var result = 0;

    for (int i = 0; i < table.length; i++) {
      var state = table[i];

      result += switch (state) {
        case 1 -> compute(1001);
        case 2 -> compute(1002);
        case 3 -> compute(1003);
        case 4 -> compute(1004);
        case 5 -> compute(1005);
        case 6 -> compute(1006);
        case 7 -> compute(1007);
        case 8 -> compute(1008);
        case 9 -> compute(1009);
        case 10 -> compute(1010);
        default -> 0;
      };
    }

    return result;
  }

  private int compute(int value) {
    return ThreadLocalRandom.current().nextInt(value * x);
  }

}