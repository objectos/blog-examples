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
package iter4;

public class Example {
  private static Thread cntr;

  public static void main(String[] args) {
    say("Hello");

    cntr = new Thread(
      Example::countdown, "cntr"
    );

    var rt = Runtime.getRuntime();

    rt.addShutdownHook(
      new Thread(
        Example::hook, "hook"
      )
    );

    cntr.start();

    say("Bye");
  };

  private static void countdown() {
    say("Hello");

    say("3 seconds countdown!");

    for (int i = 3; i > 0; i--) {
      say(Integer.toString(i));

      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        say("Got interrupted. Cleaning up...");

        return;
      }
    }

    say("Bye");
  }

  private static void hook() {
    say("Hello");

    if (cntr != null && cntr.isAlive()) {
      say("I will interrupt cntr");

      cntr.interrupt();

      while (cntr.isAlive()) {
        say("cntr is alive");

        Thread.onSpinWait();
      }
    }

    say("Bye");
  }

  private static void say(String what) {
    var ct = Thread.currentThread();

    var name = ct.getName();

    System.out.println("%4s: %s".formatted(name, what));
  }
}