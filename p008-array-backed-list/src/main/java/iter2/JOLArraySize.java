/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package iter2;

import static java.lang.System.out;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

public class JOLArraySize {
  public static void main(String[] args) {
    out.println(VM.current().details());

    var max = Integer.MAX_VALUE - 8;

    out.println("String[" + max + "]");
    out.println(ClassLayout.parseInstance(new String[max]).toPrintable());

    out.println("String[1_000]");
    out.println(ClassLayout.parseInstance(new String[1_000]).toPrintable());
  }
}