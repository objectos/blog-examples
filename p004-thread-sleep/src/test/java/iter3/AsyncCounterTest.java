/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package iter3;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.Semaphore;
import org.testng.annotations.Test;

public class AsyncCounterTest implements AsyncCounter.Listener {
  private final Semaphore semaphore = new Semaphore(0);

  @Override
  public void countingOver() {
    semaphore.release();
  }

  @Test
  public void test() throws InterruptedException {
    var startTime = System.currentTimeMillis();
    var counter = new AsyncCounter(this);

    counter.startCounting();

    semaphore.acquire();

    assertEquals(counter.get(), AsyncCounter.COUNT_TO);

    var totalTime = System.currentTimeMillis() - startTime;
    System.out.println("totalTime=" + totalTime);
  }
}