/*
 * Copyright (C) 2024 Objectos Software LTDA.
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
package iter02;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class CodeTest {

  @Test(description = "single embedded expression")
  public void testCase02() {
    Code code;
    code = new Code();

    String message;
    message = "Hello world!";

    String java;
    java = code."""
    public class TestCase02 {
      public static void main(String[] args) {
        System.out.println("\{message}");
      }
    }
    """;

    assertEquals(java, """
    public class TestCase02 {
      public static void main(String[] args) {
        System.out.println("Hello world!");
      }
    }
    """);
  }

}