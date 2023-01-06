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
package shared;

import com.github.javaparser.ParseProblemException;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class JdkSearch {
  private final Path basePath;

  private JdkSearch(Path basePath) {
    this.basePath = basePath;
  }

  public static void main(String[] args) throws IOException {
    var basePath = Path.of(System.getProperty("user.home"), "kdo/projetos/jdk", "src");

    var search = new JdkSearch(basePath);

    search.execute();
  }

  public final void execute() throws IOException {
    try (var walk = Files.walk(basePath)) {
      walk.filter(Files::isRegularFile)
          .filter(this::isJavaFile)
          .filter(this::hasGenericConstructor)
          .forEach(System.out::println);
    } catch (IOException e) {
      System.err.println("Failed to walk basePath");

      throw e;
    }
  }

  private boolean hasGenericConstructor(Path p) {
    CompilationUnit unit;

    try {
      unit = StaticJavaParser.parse(p);
    } catch (ParseProblemException e) {
      System.err.print("""
      Ignored: %s
      Cause  : %s
      """.formatted(p, e.getMessage()));

      return false;
    } catch (IOException e) {
      System.err.println("Failed to parse");

      throw new UncheckedIOException(e);
    }

    var maybePrimaryType = unit.getPrimaryType();

    if (maybePrimaryType.isEmpty()) {
      return false;
    }

    var primaryType = maybePrimaryType.get();

    var constructors = primaryType.getConstructors();

    for (var constructor : constructors) {
      var typeParameters = constructor.getTypeParameters();

      if (typeParameters.isEmpty()) {
        continue;
      }

      return true;
    }

    return false;
  }

  private boolean isJavaFile(Path p) {
    var fileName = p.getFileName().toString();

    return fileName.endsWith(".java");
  }
}