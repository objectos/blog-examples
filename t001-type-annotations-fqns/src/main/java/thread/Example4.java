/*
 * Copyright 2023 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package thread;

import shared.Annotations.One;
//import shared.Annotations.Two;

public class Example4 {
  public shared.Types.@One StaticNested a;

  // does not compile!
  //public shared.@One Types.StaticNested b;

  // does not compile!
  //public shared.@One Types.@Two StaticNested c;

  static class StaticNested {}
}