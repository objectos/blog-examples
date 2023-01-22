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

public class BoxObjectosCodeExample extends JavaTemplate {
  public @interface TypeAnnotation {}

  public static void main(String[] args) {
    System.out.println(
      new BoxObjectosCodeExample()
    );
  }

  @Override
  protected final void definition() {
    //    code(
    //      _package("com.example"),
    //
    //      autoImports(),
    //
    //      at(t(TypeAnnotation.class)),
    //      _public(), _class("Box"), body(
    //        _private(), _final(), _int(), id("value"),
    //
    //        _public(), constructor(_int(), id("value")), block(
    //          _this(), id("value"), gets(), n("value")
    //        ),
    //
    //        _public(), _final(), _int(), method("get"), block(
    //          _return(), n("value")
    //        )
    //      )
    //    );
  }
}