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
@Warmup(time = 2, timeUnit = TimeUnit.SECONDS)
@Measurement(time = 2, timeUnit = TimeUnit.SECONDS)
public class Benchmarks {
  int[] lookup;
  int[] table;
  int x = 123;

  @Setup
  public void _setup() {
    lookup = new int[] {257, 68, 13, 16, 529, 528, 144, 146, 32, 96, 160, 162};
    table = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12};
  }

  @Benchmark
  public int lookupSwitch() {
    var result = 0;

    for (int i = 0; i < lookup.length; i++) {
      var state = lookup[i];

      result += switch (state) {
        case 257 -> compute(1001);
        case 68 -> compute(1002);
        case 13 -> compute(1003);
        case 16 -> compute(1004);
        case 529 -> x;
        case 528 -> compute(1006);
        case 144 -> compute(1007);
        case 146 -> compute(1008);
        case 32 -> 1234;
        case 96 -> compute(1010);
        case 160 -> state;
        case 162 -> state;
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
        case 5 -> x;
        case 6 -> compute(1006);
        case 7 -> compute(1007);
        case 8 -> compute(1008);
        case 9 -> 1234;
        case 10 -> compute(1010);
        case 11 -> state;
        case 12 -> state;
        default -> 0;
      };
    }

    return result;
  }

  private int compute(int value) {
    return value * x;
  }
}