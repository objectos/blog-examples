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

public class ByteCodeFauxGenerator {
  private int value = -1;

  public static void main(String[] args) {
    var gen = new ByteCodeFauxGenerator();

    gen.execute();
  }

  public final void execute() {
    comment("class");

    value("CLASS");
    value("MODIFIER");
    value("IDENTIFIER");

    comment("statements");

    value("LOCAL_VARIABLE");
    value("RETURN_STATEMENT");
  }

  private void comment(String string) {
    out.println();
    out.println("// " + string);
    out.println();
  }

  private void value(String string) {
    out.println("static final int " + string + " = " + value-- + ";");
  }
}
