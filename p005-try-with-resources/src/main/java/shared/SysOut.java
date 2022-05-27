/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package shared;

import java.io.Closeable;
import java.io.IOException;

public class SysOut implements Closeable {

  final String name;

  SysOut(String name) {
    this.name = name;

    print0("created");
  }

  public static SysOut create(String name) throws IOException {
    return new SysOut(name);
  }

  public static SysOut throwOnClose(String name) throws IOException {
    return new ThrowOnClose(name);
  }

  public static SysOut throwOnCreate(String name) throws IOException {
    throw new IOException("Failed to create: " + name);
  }

  @Override
  public void close() throws IOException {
    print0("closed");
  }

  public void println(String s) {
    print0(s);
  }

  final void print0(String string) {
    System.out.println(name + ": " + string);
  }

  private static class ThrowOnClose extends SysOut {
    ThrowOnClose(String name) {
      super(name);
    }

    @Override
    public void close() throws IOException {
      print0("close() called");

      throw new IOException("Failed to close: " + name);
    }
  }

}