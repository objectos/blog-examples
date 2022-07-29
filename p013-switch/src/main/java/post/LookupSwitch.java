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

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Thread)
public class LookupSwitch {

  @Param({"1", "2", "3", "4", "5", "6", "7", "255", "1024"})
  int state;

  @Benchmark
  public int benchmark() {
    return switch (state) {
      case 1 -> 1001;
      case 2 -> 1002;
      case 3 -> 1003;
      case 4 -> 1004;
      case 5 -> 1005;
      case 6 -> 1006;
      case 7 -> 1007;
      case 255 -> 1255;
      default -> Integer.MAX_VALUE;
    };
  }

}