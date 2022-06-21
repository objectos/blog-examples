/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package iter1;

import java.util.ArrayList;
import java.util.List;

public class RawList {
  @SuppressWarnings({"rawtypes", "unchecked"})
  public static void main(String[] args) {
    List raw = new ArrayList<String>();

    raw.add("1");
    raw.add("2");
    raw.add(Integer.valueOf(3));

    List<String> unchecked = raw;

    for (String s : unchecked) {
      System.out.println(s);
    }
  }
}