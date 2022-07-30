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
package post;

import java.util.Arrays;

public class TableSwitch {
  private static final int TABLESWITCH = 0xaa;

  private static final int PRINT_STRING = -1;

  private static final int STOP = -2;

  private static final int NOOP = -3;

  private final int[] instructions = new int[256];

  private final String[] strings = new String[16];

  private int stringsIndex;

  private int ip;

  public TableSwitch() {
    Arrays.fill(instructions, NOOP);
  }

  public static void main(String[] args) {
    var tswitch = new TableSwitch();
    tswitch.set(1, TABLESWITCH);
    tswitch.set(2, 53); // default
    tswitch.set(3, 5); // low
    tswitch.set(4, 8); // high
    tswitch.set(5, 32); // case 5
    tswitch.set(6, 39); // case 6
    tswitch.set(7, 53); // case 7
    tswitch.set(8, 46); // case 8

    tswitch.printString(32, "five");
    tswitch.printString(39, "six");
    tswitch.printString(46, "eight");
    tswitch.printString(53, "other");

    tswitch.execute(5);
    tswitch.execute(6);
    tswitch.execute(7);
    tswitch.execute(8);
    tswitch.execute(9);
  }

  public final void execute(int value) {
    ip = 0;

    while (true) {
      var inst = instructions[ip++];

      if (inst == NOOP) {
        continue;
      }

      if (inst == TABLESWITCH) {
        tableswitch(value);

        continue;
      }

      if (inst == PRINT_STRING) {
        var index = instructions[ip++];

        var s = strings[index];

        System.out.println(s);

        continue;
      }

      if (inst == STOP) {
        return;
      }

      throw new UnsupportedOperationException("instruction=" + inst);
    }
  }

  private void printString(int index, String string) {
    instructions[index] = PRINT_STRING;
    instructions[index + 1] = stringsIndex;
    strings[stringsIndex++] = string;
    instructions[index + 2] = STOP;
  }

  private void set(int index, int value) {
    instructions[index] = value;
  }

  private void tableswitch(int value) {
    var def = instructions[ip++];
    var low = instructions[ip++];
    var high = instructions[ip++];

    if (value < low || value > high) {
      ip = def;
    } else {
      var offset = value - low;

      ip = instructions[ip + offset];
    }
  }
}