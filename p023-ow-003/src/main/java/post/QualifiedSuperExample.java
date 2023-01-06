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

import static java.lang.System.out;

public class QualifiedSuperExample {

  static class InnerChild extends Outer.Inner {
    InnerChild() {
      new Outer().super();

      System.out.println("InnerChild()");
    }

    InnerChild(Outer outer) {
      outer.super();

      System.out.println("InnerChild(Outer)");
    }
  }

  static class Outer {
    class Inner {
      Inner() { out.println("Inner()"); }
      Inner(boolean ignore) {}
    }

    Outer() { out.println("Outer()"); }

    Outer(boolean ignore) {}
  }

}