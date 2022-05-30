/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package shared;

public final class Close {
  public static Throwable ifPossible(Throwable t, AutoCloseable c) {
    var res = t;

    if (c != null) {
      try {
        c.close();
      } catch (Throwable e) {
        if (res == null) {
          res = e;
        } else {
          res.addSuppressed(e);
        }
      }
    }

    return res;
  }
}