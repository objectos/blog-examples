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
package artigo;

public class TopLevel {

  public static void main(String[] args) {
    var nested = new TopLevel.Nested();

    System.out.println(nested);

    // erro de compilação
    // var inner = new Outer.Inner();

    var topLevel = new TopLevel();

    var inner = topLevel.new Inner();

    System.out.println(inner);
  }

  public static class Nested {}

  public class Inner {}

}