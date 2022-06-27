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
package iter2;

import static java.lang.System.out;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

public class JOLArraySize {
  public static void main(String[] args) {
    out.println(VM.current().details());

    var max = Integer.MAX_VALUE - 8;

    out.println("String[" + max + "]");
    out.println(ClassLayout.parseInstance(new String[max]).toPrintable());

    out.println("String[1_000]");
    out.println(ClassLayout.parseInstance(new String[1_000]).toPrintable());
  }
}