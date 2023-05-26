/*
 * Copyright 2023 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package interrupted;

public class Exemplo01 {
  public static void main(String[] args) {
    Print.msg("INÍCIO");

    var multiplos = new Multiplos01();

    multiplos.start();

    multiplos.interrupt();

    Print.msg("FIM");
  }
}