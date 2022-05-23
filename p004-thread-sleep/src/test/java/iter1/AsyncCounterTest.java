/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package iter1;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class AsyncCounterTest {
  @Test
  public void test() throws InterruptedException {
    var startTime = System.currentTimeMillis();
    var counter = new AsyncCounter();

    counter.startCounting();

    Thread.sleep(1000);

    assertEquals(counter.get(), AsyncCounter.COUNT_TO);

    var totalTime = System.currentTimeMillis() - startTime;
    System.out.println("totalTime=" + totalTime);
  }
}