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

import java.util.Set;
import java.util.TreeSet;
import objectos.html.tmpl.AttributeName;
import objectos.html.tmpl.StandardAttributeName;

public final class DistinctClassNames extends SimpleVisitor {
  private boolean collect;

  private final Set<String> names = new TreeSet<>();

  @Override
  public final void attribute(AttributeName name) {
    if (name == StandardAttributeName.CLASS) {
      collect = true;
    }
  }

  @Override
  public final void attributeFirstValue(String value) {
    if (collect) {
      names.add(value);
    }
  }

  @Override
  public final void attributeNextValue(String value) {
    attributeFirstValue(value);
  }

  @Override
  public final void attributeValueEnd() {
    collect = false;
  }

  @Override
  public final void documentEnd() {
    for (var name : names) {
      System.out.println(name);
    }
  }

  @Override
  public final void documentStart() {
    collect = false;

    names.clear();
  }
}