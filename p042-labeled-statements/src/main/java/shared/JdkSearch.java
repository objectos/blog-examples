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
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.TypeDeclaration;
import com.github.javaparser.ast.expr.SimpleName;
import com.github.javaparser.ast.stmt.Statement;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

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
          .filter(this::processFile)
          .forEach(System.out::println);
    } catch (IOException e) {
      System.err.println("Failed to walk basePath");

      throw e;
    }
  }

  private SimpleName findLabel(Statement stmt) {
    if (stmt.isLabeledStmt()) {
      var labeled = stmt.asLabeledStmt();

      return labeled.getLabel();
    }

    for (var node : stmt.getChildNodes()) {
      if (node instanceof Statement child) {
        var maybe = findLabel(child);

        if (maybe != null) {
          return maybe;
        }
      }
    }

    return null;
  }

  private boolean isJavaFile(Path p) {
    var fileName = p.getFileName().toString();

    return fileName.endsWith(".java");
  }

  private boolean processFile(Path p) {
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

    return processType(maybePrimaryType.get());
  }

  private boolean processMethod(TypeDeclaration<?> parent, MethodDeclaration method) {
    var maybeBody = method.getBody();

    if (maybeBody.isEmpty()) {
      return false;
    }

    var body = maybeBody.get();

    var statements = body.getStatements();

    var maybeLabel = Optional.<SimpleName> empty();

    for (var stmt : statements) {
      var label = findLabel(stmt);

      if (label != null) {
        maybeLabel = Optional.of(label);

        break;
      }
    }

    if (maybeLabel.isPresent()) {
      System.out.println(
        "Enclosing=" + parent.getNameAsString() + ";Method=" + method.getNameAsString()
      );

      return true;
    } else {
      return false;
    }
  }

  private boolean processType(TypeDeclaration<?> type) {
    var result = false;

    for (var member : type.getMembers()) {
      var found = false;

      if (member.isTypeDeclaration()) {
        found = processType(member.asTypeDeclaration());
      } else if (member.isMethodDeclaration()) {
        found = processMethod(type, member.asMethodDeclaration());
      }

      if (found) {
        result = true;

        break;
      }
    }

    return result;
  }
}