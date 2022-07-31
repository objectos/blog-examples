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

public class LookupSwitchExample {
  public String lookupSwitch(int value) {
    return switch (value) {
      case 100 -> oneHundred();
      case 10 -> ten();
      case 1000 -> oneThousand();
      default -> default_();
    };
  }

  private String ten() { return "ten"; }
  private String oneHundred() { return "one hundred"; }
  private String oneThousand() { return "one thousand"; }
  private String default_() { return "other"; }
}