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

public class ReturnStatement extends JavaTemplate {

  private static final String EXAMPLE = "com.example";

  public static void main(String[] args) {
    System.out.println(new ReturnStatement());
  }

  @Override
  protected final void definition() {
    // @formatter:off
    _package(EXAMPLE);

    autoImports();

    _public(); _class("ReturnStatement"); body(

      t(String.class), id("name"),

      t(String.class), method("expressionName"), block(
        _return(), n("name")
      ),

      _int(), method("autoChain"), block(
        _return(), n("name"), invoke("length")
      ),

      _int(), method("literalInt"), block(
        _return(), i(123)
      ),

      t(EXAMPLE, "Foo"),
      method("classInstanceCreation", t(String.class), id("value")),
      block(
        _return(), _new(t(EXAMPLE, "Foo"), n("value"))
      )

    );
  }

}