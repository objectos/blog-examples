/*
 * Copyright (C) 2022 Objectos Software LTDA.
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

class AsyncCounter implements Runnable {
  static final int COUNT_TO = 1_000_000;

  private final Listener listener;

  private volatile int value;

  public AsyncCounter(Listener listener) {
    this.listener = listener;
  }

  public int get() {
    return value;
  }

  @Override
  public void run() {
    while (value < COUNT_TO) {
      value++;
    }

    listener.countingOver();
  }

  public void startCounting() {
    var t = new Thread(this);

    t.start();
  }

  interface Listener {
    void countingOver();
  }
}