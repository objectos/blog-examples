/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package iter1;

public class VMLimit {
  public static void main(String[] args) {
    var abc = new String[Integer.MAX_VALUE];

    System.out.format("Actual array length is %,d%n", abc.length);

    var i = 0;

    abc[i++] = "A";
    abc[i++] = "B";
    abc[i++] = "C";
    abc[i++] = "D";

    System.out.println("Bye");
  }
}
