/*
 * Copyright 2023 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package thread;

import shared.Annotations.One;
import shared.Annotations.Two;
import shared.Types;

public class Example5 {
  public Types.@One Inner a;

  public @One Types.Inner b;

  public @One Types.@Two Inner c;

  public Types.@One StaticNested d;
}