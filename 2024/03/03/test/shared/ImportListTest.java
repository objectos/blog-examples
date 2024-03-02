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
package shared;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class ImportListTest {

  @Test(description = "Happy path")
  public void testCase01() {
    ImportList imports;
    imports = new ImportList("com.example");

    ClassName list;
    list = ClassName.of("java.util", "List");

    ClassName awt;
    awt = ClassName.of("java.awt", "List");

    ClassName inputStream;
    inputStream = ClassName.of("java.io", "InputStream");

    ClassName foo;
    foo = ClassName.of("com.example", "Foo");

    assertEquals(imports.process(list), "List");
    assertEquals(imports.process(awt), "java.awt.List");
    assertEquals(imports.process(inputStream), "InputStream");
    assertEquals(imports.process(foo), "Foo");
    assertEquals(imports.toString(), """

    import java.io.InputStream;
    import java.util.List;
    """);
  }

}