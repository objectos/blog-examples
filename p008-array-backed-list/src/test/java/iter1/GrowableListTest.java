/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package iter1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class GrowableListTest {

  @Test
  public void add() {
    var l = new GrowableList<String>();

    assertTrue(l.add("A"));
    assertTrue(l.add("B"));
    assertTrue(l.add("C"));
    assertTrue(l.add("D"));
    assertTrue(l.add("E"));

    assertEquals(l.toArray(), arr("A", "B", "C", "D", "E"));
  }

  private Object[] arr(Object... a) {
    return a;
  }

}