/*
 * Copyright 2023 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package interrupted;

public class Exemplo02 {
  public static void main(String[] args) {
    Print.msg("INÍCIO");

    var multiplos = new Multiplos02();

    multiplos.start();

    while (multiplos.impressos < 5) {
      Thread.onSpinWait();
    }

    multiplos.interrupt();

    Print.msg("FIM");
  }
}