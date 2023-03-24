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

import objectos.html.HtmlTemplate;
import objectos.html.tmpl.AttributeName;
import objectos.html.tmpl.StandardElementName;

public class SimpleVisitor implements HtmlTemplate.Visitor {

  @Override
  public void attribute(AttributeName name) {}

  @Override
  public void attributeFirstValue(String value) {}

  @Override
  public void attributeNextValue(String value) {}

  @Override
  public void attributeValueEnd() {}

  @Override
  public void doctype() {}

  @Override
  public void documentEnd() {}

  @Override
  public void documentStart() {}

  @Override
  public void endTag(StandardElementName name) {}

  @Override
  public void raw(String value) {}

  @Override
  public void startTag(StandardElementName name) {}

  @Override
  public void startTagEnd(StandardElementName name) {}

  @Override
  public void text(String value) {}

}