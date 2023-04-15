/*
 * Copyright 2023 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package thread;

import shared.Annotations.One;

public class Example2 {
  // does not compile!
  // public @One shared.Types.Inner a;

  public shared.Types.@One Inner a;

  static class Inner {}
}