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

import objectos.html.pseudom.DocumentProcessor;
import objectos.html.pseudom.HtmlDocument;
import objectos.html.pseudom.HtmlElement;
import objectos.html.tmpl.StandardElementName;

public class WhyPseudoDomProc implements DocumentProcessor {
  @Override
  public final void process(HtmlDocument document) {
    var nodes = document.nodes();

    var nodesIter = nodes.iterator();

    assertTrue(nodesIter.hasNext());

    var h1 = (HtmlElement) nodesIter.next();

    assertTrue(h1.hasName(StandardElementName.H1));

    assertTrue(nodesIter.hasNext());

    var p = (HtmlElement) nodesIter.next();

    assertTrue(p.hasName(StandardElementName.P));

    assertTrue(h1 == p);

    assertTrue(h1.hasName(StandardElementName.H1));
  }

  private void assertTrue(boolean expected) {
    if (!expected) {
      throw new AssertionError();
    }
  }
}
