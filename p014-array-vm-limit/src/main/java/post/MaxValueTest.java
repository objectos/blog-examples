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

public class MaxValueTest {
  public static void main(String[] args) {
    oom(0, "Requested array size exceeds VM limit");
    oom(1, "Requested array size exceeds VM limit");
    oom(2, "Java heap space");
    oom(3, "Java heap space");

    System.out.println("Test was sucessful");
  }

  private static void oom(int value, String expected) {
    try {
      System.out.println("Will create value=" + value);

      @SuppressWarnings("unused")
      var a = new Object[Integer.MAX_VALUE - value];

      throw new AssertionError("Expected creation error for value=" + value);
    } catch (OutOfMemoryError e) {
      var m = e.getMessage();

      if (!m.equals(expected)) {
        throw new AssertionError("""
        Expected:
        %s
        But got:
        %s
        """.formatted(expected, m));
      }
    }
  }
}
