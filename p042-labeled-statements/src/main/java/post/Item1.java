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

public class Item1 {
  @SuppressWarnings("unused")
  public static void main(String[] args) {
    question: out.println("Does this compile?");

    branch: if (args.length > 0) {
      out.println("It has args!");
    } else {
      out.println("No args...");
    }

    assertion: assert args != null : "uh-oh";

    empty: ;

    block: {
      break block;
    }

    now: break now;

    sync: synchronized (Item1.class) {
      out.println("Synchronized statement");
      break sync;
    }

    end: out.println(new Item1());
  }

  @SuppressWarnings("unused")
  @Override
  public String toString() {
    toString: return "Labeled statements!";
  }
}