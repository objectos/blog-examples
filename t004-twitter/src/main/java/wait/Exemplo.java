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
package wait;

public class Exemplo {
  public static void main(String[] args) throws InterruptedException {
    ThreadB b = new ThreadB();

    b.start();

    Thread.sleep(100);

    synchronized (b) {
      try {
        System.out.println("Aguardando o b completar...");
        b.wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      System.out.println("Total é igual a: " + b.total);
    }
  }

  private static class ThreadB extends Thread {

    int total;

    @Override
    public void run() {
      synchronized (this) {
        for (int i = 0; i < 200; i++) {
          total = i;
        }
        notify();
      }
    }
  }

}
