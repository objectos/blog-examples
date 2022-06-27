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
package iter5;

import java.io.IOException;
import shared.Resource;

public class Try {
  // Warning: this code is problematic
  // It is written this way or educational purposes
  // Please avoid code like this in production
  public static void main(String[] args) throws IOException {
    Resource a = null;
    Resource b = null;

    try {
      a = Resource.create("A");
      a.throwOnWrite("Try statement (iteration 5)");

      b = Resource.create("B");
      b.write("Try statement (iteration 5)");
    } catch (IOException e) {
      System.err.println("The program failed: " + e.getMessage());

      return; // explicitly stop execution
    } finally {
      // do not do this!!
      b.close();
      a.close();
    }

    System.out.println("More instructions...");
  }
}
