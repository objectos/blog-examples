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

public class LookupSwitch {
  public static void main(String[] args) {
    var vm = new VirtualMachine();

    // add our lookupswitch instruction
    // values taken from `javap` output
    vm.lookupswitch(
      57, // default
      3, // count

      10, 43, // case 10 value
      100, 36, // case 100 value
      1000, 50 // case 1000 value
    );

    // our 'methods'
    // i.e. the jump locations for our 'cases'
    vm.printString(36, "one hundred");
    vm.printString(43, "ten");
    vm.printString(50, "one thousand");
    vm.printString(57, "other");

    // executes the switch with
    // the specified values
    vm.execute(10);
    vm.execute(50);
    vm.execute(100);
    vm.execute(1000);
    vm.execute(5000);
  }
}
