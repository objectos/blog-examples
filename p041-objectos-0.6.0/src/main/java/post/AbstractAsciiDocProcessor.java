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

import objectos.asciidoc.AsciiDoc;
import objectos.asciidoc.DocumentAttributes;
import objectos.asciidoc.InlineMacroAttributes;
import objectos.asciidoc.LinkText;

public abstract class AbstractAsciiDocProcessor implements AsciiDoc.Processor {

  @Override
  public void boldEnd() {}

  @Override
  public void boldStart() {}

  @Override
  public void documentEnd() {}

  @Override
  public void documentStart(DocumentAttributes attributes) {}

  @Override
  public void headingEnd(int level) {}

  @Override
  public void headingStart(int level) {}

  @Override
  public void inlineMacro(String name, String target, InlineMacroAttributes attributes) {}

  @Override
  public void italicEnd() {}

  @Override
  public void italicStart() {}

  @Override
  public void lineFeed() {}

  @Override
  public void link(String href, LinkText text) {}

  @Override
  public void listingBlockEnd() {}

  @Override
  public void listingBlockStart() {}

  @Override
  public void listItemEnd() {}

  @Override
  public void listItemStart() {}

  @Override
  public void monospaceEnd() {}

  @Override
  public void monospaceStart() {}

  @Override
  public void paragraphEnd() {}

  @Override
  public void paragraphStart() {}

  @Override
  public void preambleEnd() {}

  @Override
  public void preambleStart() {}

  @Override
  public void sectionEnd() {}

  @Override
  public void sectionStart(int level) {}

  @Override
  public void sectionStart(int level, String style) {}

  @Override
  public void sourceCodeBlockEnd() {}

  @Override
  public void sourceCodeBlockStart(String language) {}

  @Override
  public void text(String s) {}

  @Override
  public void unorderedListEnd() {}

  @Override
  public void unorderedListStart() {}

}