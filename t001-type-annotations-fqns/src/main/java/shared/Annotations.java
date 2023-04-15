/*
 * Copyright 2023 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package shared;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

public class Annotations {

  @Target(ElementType.TYPE_USE)
  public @interface One {}

  @Target(ElementType.TYPE_USE)
  public @interface Two {}

}