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

    out.println("String[1000]");
    out.println(ClassLayout.parseInstance(new String[1000]).toPrintable());

    out.println("int[1000]");
    out.println(ClassLayout.parseInstance(new int[1000]).toPrintable());
  }
}