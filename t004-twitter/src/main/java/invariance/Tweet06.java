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
package invariance;

import java.util.List;

public class Tweet06 {
  public void exemplo01() {
    accept01(Integer.valueOf(1));
  }

  public void exemplo02() {
    // não compila
    //accept02(new ArrayList<Integer>());
  }

  private void accept01(Number number) {}

  @SuppressWarnings("unused")
  private void accept02(List<Number> numbers) {}
}