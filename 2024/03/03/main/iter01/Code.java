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
package iter01;

import java.util.List;

public class Code
    implements
    StringTemplate.Processor<String, RuntimeException> {

  @Override
  public final String process(StringTemplate template) throws RuntimeException {
    List<String> fragments;
    fragments = template.fragments();

    int fragmentsSize;
    fragmentsSize = fragments.size();

    if (fragmentsSize == 1) {
      return fragments.getFirst();
    }

    return process0(template, fragments);
  }

  protected String process0(StringTemplate template, List<String> fragments) {
    throw new UnsupportedOperationException("Implement me");
  }

}