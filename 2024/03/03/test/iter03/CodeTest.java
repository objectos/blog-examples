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
package iter03;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import shared.ClassName;
import shared.ImportList;

public class CodeTest {

  @Test
  public void testCase03() {
    Code code;
    code = new Code();

    ClassName LIST;
    LIST = ClassName.of("java.util", "List");

    String packageName;
    packageName = "com.example";

    ImportList imports;
    imports = code.importList(packageName);

    String java;
    java = code."""
  package \{packageName};
  \{imports}
  public class TestCase02 {
    public static void main(String[] args) {
      \{LIST}<String> msgs = \{LIST}.of("Foo", "Bar");
      for (var msg : msgs) {
        System.out.println(msg);
      }
    }
  }
  """;

    assertEquals(java, """
  package com.example;

  import java.util.List;

  public class TestCase02 {
    public static void main(String[] args) {
      List<String> msgs = List.of("Foo", "Bar");
      for (var msg : msgs) {
        System.out.println(msg);
      }
    }
  }
  """);
  }

}