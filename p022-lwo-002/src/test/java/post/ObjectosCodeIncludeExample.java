/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package post;

import java.util.List;
import objectos.code.JavaTemplate;

public class ObjectosCodeIncludeExample extends JavaTemplate {

  private final List<String> fieldNames = List.of("a", "b", "c");

  public static void main(String[] args) {
    System.out.println(new ObjectosCodeIncludeExample());
  }

  @Override
  protected final void definition() {
    _class(
      id("Example"),
      include(this::generateFields)
    );
  }

  private void generateFields() {
    for (var fieldName : fieldNames) {
      field(_int(), id(fieldName));
    }
  }

}