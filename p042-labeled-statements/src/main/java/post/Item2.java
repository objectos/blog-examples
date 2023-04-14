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
package post;

import static java.lang.System.out;

public class Item2 {
  public static void main(String[] args) {
    var item = new Item2();
    
    item.subStatements(args);
  }
  
  @SuppressWarnings("unused")
  final void subStatements(String[] args) {
    while (!interrupted())
      action: execute();

    if (enabled())
      whenTrue: out.println("It is enabled!");
    else
      whenFalse: out.println("Not enabled...");

    for (int i = 0; i < args.length; i++)
      print: out.println(args[i]);
  }
  
  private boolean enabled() { return false; }
  
  private void execute() {}
  
  private boolean interrupted() { return true;  }

}
