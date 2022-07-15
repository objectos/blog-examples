/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package iter5;

import java.util.logging.Level;

public class InvokeTest {
  public static void main(String[] args) {
    LogFormatter formatter = new LogFormatter();

    Log log = new Log(12345L, Level.INFO, "Hello world");

    Payload p = new Payload(formatter, null);

    System.out.println(p.data);
  }
}

interface Formatter<T> {
  String format(T value);
}

class Log {
  final long millis;
  final Level level;
  final String msg;

  public Log(long millis, Level level, String msg) {
    this.millis = millis;
    this.level = level;
    this.msg = msg;
  }
}

class LogFormatter implements Formatter<Log> {
  @Override
  public final String format(Log log) {
    return String.format(
      "{millis: %d, level: \"%s\", msg: \"%s\"}",
      log.millis, log.level, log.msg
    );
  }
}

class Payload {
  final String data;

  public <T> Payload(Formatter<T> f, T value) {
    this.data = f.format(value);
  }
}

class Sub extends Payload {
  public Sub(Formatter<Log> f, Log value) {
    <Log> super(f, value);
  }
}