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

public class TableSwitch {
  public static void main(String[] args) {
    var vm = new VirtualMachine();

    // add our tableswitch instruction
    // values taken from `javap` output
    vm.tableswitch(
      53, // default
      5, // low
      8, // high

      32, // case 5
      39, // case 6
      53, // case 7 == default
      46 // case 8
    );

    // our 'methods'
    // i.e. the jump locations for our 'cases'
    vm.printString(32, "five");
    vm.printString(39, "six");
    vm.printString(46, "eight");
    vm.printString(53, "other");

    // executes the switch with
    // the specificed values
    vm.execute(5);
    vm.execute(6);
    vm.execute(7);
    vm.execute(8);
    vm.execute(9);
  }
}
