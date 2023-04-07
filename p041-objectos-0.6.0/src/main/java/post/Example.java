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

import objectos.asciidoc.AsciiDoc;

public class Example {
  public static void main(String[] args) {
    var asciiDoc = AsciiDoc.create();

    var source = """
    = Hello Objectos AsciiDoc

    Let's see some of the implemented
    AsciiDoc language features

    == Section title

    A paragraph followed by a list.

    * item 1
    * item 2

    [,java]
    ----
    class Foo {}
    ----
    """;

    var processor = new MyProcessor();

    asciiDoc.process(source, processor);
  }

  private static class MyProcessor extends AbstractAsciiDocProcessor {
    @Override
    public void headingEnd(int level) {
      out.print("</h");
      out.print(level);
      out.println(">");
      out.println();
    }

    @Override
    public void headingStart(int level) {
      out.print("<h");
      out.print(level);
      out.print(">");
    }

    @Override
    public void unorderedListEnd() { out.println("</ul>"); out.println(); }

    @Override
    public void unorderedListStart() { out.println("<ul>"); }

    @Override
    public void listItemEnd() { out.println("</li>"); }

    @Override
    public void listItemStart() { out.print("<li>"); }

    @Override
    public void paragraphEnd() { out.println("</p>"); out.println(); }

    @Override
    public void paragraphStart() { out.print("<p>"); }

    @Override
    public void sourceCodeBlockEnd() { out.println(); out.println("</code></pre>"); }

    @Override
    public void sourceCodeBlockStart(String language) {
      out.print("<pre><code style=\"");
      out.print(language);
      out.println("\">");
    }

    @Override
    public void text(String s) { out.print(s); }
  }

}