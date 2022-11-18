/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package post;

import static java.lang.System.out;

public class ByteCodeFauxGenerator {
  private int value = -1;

  public static void main(String[] args) {
    var gen = new ByteCodeFauxGenerator();

    gen.execute();
  }

  public final void execute() {
    comment("class");

    value("CLASS");
    value("MODIFIER");
    value("IDENTIFIER");

    comment("statements");

    value("LOCAL_VARIABLE");
    value("RETURN_STATEMENT");
  }

  private void comment(String string) {
    out.println();
    out.println("// " + string);
    out.println();
  }

  private void value(String string) {
    out.println("static final int " + string + " = " + value-- + ";");
  }
}
