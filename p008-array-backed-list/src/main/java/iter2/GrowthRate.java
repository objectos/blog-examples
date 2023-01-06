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
package iter2;

public class GrowthRate {
  public static void main(String[] args) {
    System.out.println("     iter :         length");
    System.out.println("--------------------------");

    int iter = 1;

    int length = 10;

    do {
      System.out.format("%9d : %,14d%n", iter++, length);

      int halfLength = length >> 1;

      length = length + halfLength;
    } while (length > 0);

    System.out.format("%9d : %,14d%n", iter, length);

    System.out.println();

    System.out.format("Soft limit: %,14d%n", Integer.MAX_VALUE - 8);
  }
}