/*
 * Copyright (C) 2022-2023 Objectos Software LTDA.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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