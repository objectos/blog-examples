/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package iter1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.UUID;
import org.testng.annotations.Test;

public class GrowableListTest {
  @Test
  public void test() {
    var list = new GrowableList<UUID>();

    var arr = new Object[100_000];

    for (int i = 0; i < arr.length; i++) {
      var uuid = UUID.randomUUID();

      assertTrue(list.add(uuid));

      arr[i] = uuid;
    }

    assertEquals(list.toArray(), arr);
  }
}