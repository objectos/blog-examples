/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package post;

public class AnnotationsAreModifiers {

  class Example01 {

    @Override
    public final String toString() {
      return "Annotations are just modifiers";
    }

  }

  class Example02 {

    public @Override final String toString() {
      return "They can go anywhere";
    }

  }

  class Example03 {

    public final @Override String toString() {
      return "I mean, really anywhere";
    }

  }

}