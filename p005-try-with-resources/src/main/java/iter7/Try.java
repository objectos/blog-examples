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
package iter7;

import java.io.IOException;
import shared.Close;
import shared.Resource;

public class Try {
  public static void main(String[] args) {
    Throwable rethrow = null;

    Resource a = null;
    Resource b = null;

    try {
      a = Resource.create("A");
      b = Resource.create("B");

      a.write("Try statement (iteration 7)");
      b.write("Try statement (iteration 7)");
    } catch (Throwable e) {
      rethrow = e;
    } finally {
      rethrow = Close.ifPossible(rethrow, b);
      rethrow = Close.ifPossible(rethrow, a);
    }

    if (rethrow instanceof RuntimeException re) {
      throw re;
    }

    if (rethrow instanceof Error err) {
      throw err;
    }

    if (rethrow instanceof IOException ioe) {
      System.err.println("The program failed: " + ioe.getMessage());

      return; // explicitly stop execution
    }

    System.out.println("More instructions...");
  }
}
