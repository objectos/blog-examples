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
package code;

import java.nio.file.OpenOption;
import java.util.Map;
import java.util.Set;
import objectos.code.JavaTemplate;

public class ParameterizedTypes extends JavaTemplate {

  public static void main(String[] args) {
    System.out.println(
      new ParameterizedTypes()
    );
  }

  @Override
  protected final void definition() {
    _package("objectos.example");

    autoImports();

    _class(
      _public(), id("ParameterizedTypesExample"),

      field(
        t(t("java.util", "Map"), t(String.class), t("java.lang", "Integer")),
        id("map")
      ),

      field(t(t(Set.class), t(OpenOption.class)), id("set")),

      field(
        t(
          t("java.util", "List"),
          t(t(Map.class), t(String.class), t(String.class))
        ), id("list")
      )
    );
  }

}