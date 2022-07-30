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

class CompilerTest {

  int value;

  /*

  public java.lang.String lookupSwitch();
    descriptor: ()Ljava/lang/String;
    flags: (0x0001) ACC_PUBLIC
    Code:
      stack=4, locals=1, args_size=1
         0: aload_0
         1: getfield      #18                 // Field value:I
         4: lookupswitch  { // 3
                       1: 40
                      10: 45
                     100: 50
                 default: 55
            }
        40: ldc           #20                 // String one
        42: goto          57
        45: ldc           #22                 // String ten
        47: goto          57
        50: ldc           #24                 // String one hundred
        52: goto          57
        55: ldc           #26                 // String other
        57: areturn

   */

  public String lookupSwitch() {
    return switch (value) {
      case 1 -> "one";
      case 10 -> "ten";
      case 100 -> "one hundred";
      default -> "other";
    };
  }

  /*

  public java.lang.String tableSwitch();
    descriptor: ()Ljava/lang/String;
    flags: (0x0001) ACC_PUBLIC
    Code:
      stack=4, locals=1, args_size=1
         0: aload_0
         1: getfield      #18                 // Field value:I
         4: tableswitch   { // 1 to 4
                       1: 36
                       2: 41
                       3: 51
                       4: 46
                 default: 51
            }
        36: ldc           #20                 // String one
        38: goto          53
        41: ldc           #32                 // String two
        43: goto          53
        46: ldc           #34                 // String four
        48: goto          53
        51: ldc           #26                 // String other
        53: areturn

   */

  public String tableSwitch() {
    return switch (value) {
      case 1 -> "one";
      case 2 -> "two";
      case 4 -> "four";
      default -> "other";
    };
  }

}