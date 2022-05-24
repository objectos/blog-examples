/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package iter2;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class AsyncCounterTest implements AsyncCounter.Listener {
  @Override
  public void countingOver() {
    synchronized (this) {
      notify();
    }
  }

  @Test(timeOut = 100)
  public void test() throws InterruptedException {
    var startTime = System.currentTimeMillis();
    var counter = new AsyncCounter(this);

    counter.startCounting();

    synchronized (this) {
      wait();
    }

    assertEquals(counter.get(), AsyncCounter.COUNT_TO);

    var totalTime = System.currentTimeMillis() - startTime;
    System.out.println("totalTime=" + totalTime);
  }
}