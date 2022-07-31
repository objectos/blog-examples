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

public class VirtualMachine {
  static final int TABLESWITCH = 0xaa;
  private static final int PRINT_STRING = -1;
  private static final int STOP = -2;
  private static final int NOOP = -3;

  private final int[] instructions = new int[256];
  private final String[] strings = new String[16];
  private int stringsIndex;
  private int ip;

  public VirtualMachine() {
    Arrays.fill(instructions, NOOP);
  }

  public final void execute(int value) {
    ip = 0;

    while (true) {
      var inst = instructions[ip++];

      if (inst == NOOP) {
        // noop
      }

      else if (inst == TABLESWITCH) {
        tableswitch(value);
      }

      else if (inst == PRINT_STRING) {
        var index = instructions[ip++];
        var s = strings[index];
        System.out.println(s);
      }

      else if (inst == STOP) {
        return;
      }

      else {
        throw new UnsupportedOperationException("instruction=" + inst);
      }
    }
  }

  public final void printString(int index, String string) {
    instructions[index] = PRINT_STRING;
    instructions[index + 1] = stringsIndex;
    strings[stringsIndex++] = string;
    instructions[index + 2] = STOP;
  }

  public final void tableswitch(int def, int low, int high, int... cases) {
    instructions[ip++] = TABLESWITCH;
    instructions[ip++] = def;
    instructions[ip++] = low;
    instructions[ip++] = high;

    for (var c : cases) {
      instructions[ip++] = c;
    }
  }

  private void tableswitch(int value) {
    var def = instructions[ip++];
    var low = instructions[ip++];
    var high = instructions[ip++];

    if (value >= low && value <= high) {
      var offset = value - low;

      ip = instructions[ip + offset];
    } else {
      ip = def;
    }
  }
}