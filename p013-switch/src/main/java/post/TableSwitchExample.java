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

public class TableSwitchExample {
  public String tableSwitch(int value) {
    return switch (value) {
      case 5 -> five();
      case 6 -> six();
      case 8 -> eight();
      default -> default_();
    };
  }

  private String five() { return "five"; }
  private String six() { return "six"; }
  private String eight() { return "eight"; }
  private String default_() { return "other"; }
}