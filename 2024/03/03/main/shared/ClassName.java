/*
 * Copyright (C) 2024 Objectos Software LTDA.
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
package shared;

import java.util.Objects;

public class ClassName {

  final String packageName;

  final String simpleName;

  private ClassName(String packageName, String simpleName) {
    this.packageName = packageName;
    this.simpleName = simpleName;
  }

  public static ClassName of(String packageName, String simpleName) {
    Objects.requireNonNull(packageName);
    Objects.requireNonNull(simpleName);

    return new ClassName(packageName, simpleName);
  }

  @Override
  public final String toString() {
    return packageName + "." + simpleName;
  }

}