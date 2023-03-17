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
package html;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import objectos.html.HtmlSink;
import objectos.html.HtmlTemplate;

public class ObjectosHtmlExample {
  public static void main(String... args) throws IOException {
    var tmpdir = System.getProperty("java.io.tmpdir");

    var target = Path.of(tmpdir, "objectos-html-example");

    var pathNames = List.of(
      "/index.html",
      "/blog/index.html",
      "/blog/2023/03/17/objectos-html-is-cool.html"
    );

    var htmlSink = new HtmlSink();

    var template = new MyTemplate();

    for (var pathName : pathNames) {
      template.pathName = pathName;

      htmlSink.toDirectory(template, target);
    }
  }

  private static class MyTemplate extends HtmlTemplate {
    private String pathName;

    @Override
    protected final void definition() {
      pathName(pathName);

      doctype();
      html(
        head(
          title("Objectos HTML example")
        ),
        body(
          p(
            a(pathTo("/index.html"), t("Home"))
          ),
          dl(
            dt("Path name:"),
            dd(pathName)
          )
        )
      );
    }
  }
}