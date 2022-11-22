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

import java.util.List;
import objectos.code.JavaTemplate;

public class ObjectosCodeIncludeExample extends JavaTemplate {

  private final List<String> fieldNames = List.of("a", "b", "c");

  public static void main(String[] args) {
    System.out.println(new ObjectosCodeIncludeExample());
  }

  @Override
  protected final void definition() {
    _class(
      id("Example"),
      include(this::generateFields)
    );
  }

  private void generateFields() {
    for (var fieldName : fieldNames) {
      field(_int(), id(fieldName));
    }
  }

}