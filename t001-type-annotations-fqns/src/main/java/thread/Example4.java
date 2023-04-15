/*
 * Copyright 2023 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package thread;

import shared.Annotations.One;
import shared.Annotations.Two;

public class Example4 {

  public shared.Types.@One Inner a;

  public shared.@One Types.Inner b;

  public shared.@One Types.@Two Inner c;

  static class Inner {}

}