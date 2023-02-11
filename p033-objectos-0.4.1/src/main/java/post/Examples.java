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

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import objectos.code.JavaTemplate;

public class Examples extends JavaTemplate {

  public static void main(String[] args) {
    System.out.println(
      new Examples()
    );
  }

  @Override
  protected final void definition() {
    _class("Examples");
    body(
      _private(), _int(), id("value"),
      t(Integer.class), n("MAX_VALUE"),

      _private(), t(String.class), id("name"),
      t(Thread.class), invoke("currentThread"), invoke("getName"),

      _private(), t(t(String.class), dim()), id("cities"),
      ainit(include(this::cities)),

      _void(), method("ifStatement"), block(
        _if(n("active")), block(
          invoke("execute")
        )
      ),

      _void(), method("throwStatement"), block(
        _throw(), _new(t(IOException.class), s("Not a directory"))
      ),

      _void(), method("equalityOp"), block(
        _if(n("a"), equalTo(), n("b")), block(
          t(System.class), n("out"),
          invoke("println", s("a is equal to b"))
        ),

        _if(n("x"), notEqualTo(), n("y")), block(
          t(System.class), n("out"),
          invoke("println", s("x is not equal to y"))
        )
      ),

      _void(), method("nullLiteral"), block(
        _var(), id("foo"), _null(),
        _this(), n("bar"), gets(), _null(),
        _if(invoke("get"), equalTo(), _null()), block(
          invoke("isNull")
        ),
        _return(), _null()
      ),

      _abstract(), _void(), method("methodDecl", include(this::param)),

      _void(), method("typeParameter"), block(
        _var(), id("list"), _new(t(t(ArrayList.class), t(Path.class))),
        _var(), id("map"), _new(t(t(HashMap.class), t(String.class), t(Integer.class)))
      )
    );
  }

  private void cities() {
    var cities = List.of(
      "Belém",
      "São Paulo",
      "Rio de Janeiro"
    );

    nl();

    for (var city : cities) {
      s(city);

      nl();
    }
  }

  private void param() {
    code(_int(), id("a"));

    if (shouldGenerateB()) {
      code(_int(), id("b"));
    }
  }

  private boolean shouldGenerateB() { return false; }

}
