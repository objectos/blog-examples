/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package iter2;

public class PlayItSafe {
  public static void main(String[] args) {
    var abc = new String[Integer.MAX_VALUE - 8];

    System.out.format("Actual array length is %,d%n", abc.length);

    var i = 0;

    abc[i++] = "A";
    abc[i++] = "B";
    abc[i++] = "C";

    System.out.println("Bye");
  }
}
