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

public class States {
  private static final int MAYBE = 1 << 0;
  private static final int START = MAYBE;

  private static final int NL = 1 << 1;

  private static final int DOCUMENT = 1 << 2;

  private static final int METADATA = 1 << 3;

  private static final int PREAMBLE = 1 << 4;

  private static final int SECTION = 1 << 5;

  private static final int HEADING = 1 << 6;

  private static final int PARAGRAPH = 1 << 7;

  private static final int ATTR = 1 << 8;

  private static final int LISTING_BLOCK = 1 << 9;

  public static void main(String[] args) {
    System.out.println(MAYBE | ATTR);

    System.out.println(DOCUMENT | HEADING);

    System.out.println(MAYBE | DOCUMENT | METADATA);

    System.out.println(PREAMBLE);

    System.out.println(PREAMBLE | LISTING_BLOCK | START);

    System.out.println(PREAMBLE | LISTING_BLOCK);

    System.out.println(PREAMBLE | PARAGRAPH);

    System.out.println(PREAMBLE | PARAGRAPH | NL);

    System.out.println(SECTION);

    System.out.println(SECTION | HEADING);

    System.out.println(SECTION | PARAGRAPH);

    System.out.println(SECTION | PARAGRAPH | NL);
  }
}
