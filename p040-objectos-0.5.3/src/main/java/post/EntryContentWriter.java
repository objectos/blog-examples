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

import objectos.html.pseudom.DocumentProcessor;
import objectos.html.pseudom.HtmlDocument;
import objectos.html.pseudom.HtmlElement;
import objectos.html.pseudom.HtmlNode;
import objectos.html.pseudom.HtmlText;
import objectos.html.tmpl.StandardElementName;

class EntryContentWriter implements DocumentProcessor {

  @Override
  public final void process(HtmlDocument document) {
    for (var node : document.nodes()) {
      if (node instanceof HtmlElement element) {
        findBody(element);
      }
    }
  }

  private void consumeBody(HtmlElement body) {
    for (var node : body.nodes()) {
      if (node instanceof HtmlElement element) {
        writeElement(element);
      }
    }
  }

  private void consumeNode(HtmlNode node) {
    if (node instanceof HtmlElement element) {
      writeElement(element);
    } else if (node instanceof HtmlText text) {
      writeText(text.value());
    }
  }

  private void findBody(HtmlElement element) {
    if (element.hasName(StandardElementName.BODY)) {
      consumeBody(element);
    } else {
      for (var node : element.nodes()) {
        if (node instanceof HtmlElement child) {
          findBody(child);
        }
      }
    }
  }

  private void writeElement(HtmlElement element) {
    var name = element.name();

    writeStartTag(name);

    if (element.isVoid()) {
      return;
    }

    for (var node : element.nodes()) {
      consumeNode(node);
    }

    writeEndTag(name);
  }

  private void writeEndTag(String name) {
    out.append("&lt;");
    out.append('/');
    out.append(name);
    out.append("&gt;");

    out.append(System.lineSeparator());
  }

  private void writeStartTag(String name) {
    out.append("&lt;");
    out.append(name);
    out.append("&gt;");
  }

  private void writeText(String value) {
    out.append(value);
  }

}
