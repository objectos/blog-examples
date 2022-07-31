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
  static final int LOOKUPSWITCH = 0xab;
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

      else if (inst == LOOKUPSWITCH) {
        lookupswitch(value);
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

  public final void lookupswitch(int def, int count, int... pairs) {
    instructions[ip++] = LOOKUPSWITCH;
    instructions[ip++] = def;
    instructions[ip++] = count;

    for (int i = 0; i < pairs.length; i += 2) {
      instructions[ip++] = pairs[i];
    }

    for (int i = 1; i < pairs.length; i += 2) {
      instructions[ip++] = pairs[i];
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

  private void lookupswitch(int value) {
    var def = instructions[ip++];
    var count = instructions[ip++];

    var res = Arrays.binarySearch(instructions, ip, ip + count, value);

    if (res >= 0) {
      var offset = res - ip;

      var index = ip + count + offset;

      ip = instructions[index];
    } else {
      ip = def;
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