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
package iter01.application;

import iter01.build.Pom;

public class MyBuild extends Pom {
  @Override
  protected void project() {
    dependencies(
      dependency("com.example", "library-a", "1.0.0"),
      dependency("com.example", "library-b", "2.0.0"),
      dependency("com.example", "library-c", "3.0.0")
    );
  }
}