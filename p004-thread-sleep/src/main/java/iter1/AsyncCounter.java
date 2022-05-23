/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package iter1;

class AsyncCounter implements Runnable {
  static final int COUNT_TO = 1_000_000;

  private volatile int value;

  public int get() {
    return value;
  }

  @Override
  public void run() {
    while (value < COUNT_TO) {
      value++;
    }
  }

  public void startCounting() {
    var t = new Thread(this);

    t.start();
  }
}