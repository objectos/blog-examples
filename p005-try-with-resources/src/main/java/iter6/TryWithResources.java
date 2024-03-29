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
package iter6;

import shared.Resource;

public class TryWithResources {
  public static void main(String[] args) {
    try (var a = Resource.create("A"); var b = Resource.create("B")) {
      a.write("Try-with-resources statement (iteration 6)");
      b.write("Try-with-resources statement (iteration 6)");
    } catch (Throwable e) {
      System.err.println("The program failed: " + e.getMessage());

      return; // explicitly stop execution
    }

    System.out.println("More instructions...");
  }
}
