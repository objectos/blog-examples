/*
 * Copyright (C) 2024 Objectos Software LTDA.
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
package objectos;

public class Example01 {
  public static void main(String[] args) {
    Logger.log("BEGIN");
    
    Runnable task;
    task = new Multiples01();

    Thread thread;
    thread = Thread.ofPlatform().name("MULT1").start(task);
    
    thread.interrupt();
    
    Logger.log("END");
  }
}