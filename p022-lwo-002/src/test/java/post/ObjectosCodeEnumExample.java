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
package post;

import objectos.code.JavaTemplate;

public class ObjectosCodeEnumExample extends JavaTemplate {

  public static void main(String[] args) {
    var ex = new ObjectosCodeEnumExample();
    System.out.println(ex.toString());
  }

  @Override
  protected final void definition() {
    code(
      _public(), _enum("Test"), _implements(), t("test", "Iface"), body(
        enumConstant("A", s("a")),

        enumConstant("B", s("b")),

        _private(), _final(), t(String.class), id("value"),

        _private(), constructor(t(String.class), id("value")), block(
          _this(), n("value"), gets(), n("value")
        ),

        at(t(Override.class)),
        _public(), _final(), t(String.class), method("toString"), block(
          _return(), n("value")
        )
      )
    );
  }

}
