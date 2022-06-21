/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package iter2;

public class GrowthRate {
  public static void main(String[] args) {
    System.out.println("     iter :         length");
    System.out.println("--------------------------");

    int iter = 1;

    int length = 10;

    do {
      System.out.format("%9d : %,14d%n", iter++, length);

      int halfLength = length >> 1;

      length = length + halfLength;
    } while (length > 0);

    System.out.format("%9d : %,14d%n", iter, length);

    System.out.println();

    System.out.format("Soft limit: %,14d%n", Integer.MAX_VALUE - 8);
  }
}