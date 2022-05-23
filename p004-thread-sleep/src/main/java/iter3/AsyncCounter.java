/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package iter3;

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