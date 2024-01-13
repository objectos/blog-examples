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
package objectos.library;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.StringWriter;
import java.io.UncheckedIOException;

final class Hi {
  private static final ObjectMapper MAPPER = new ObjectMapper();
  
  static {
    try {
      // just to trigger a class load from the dependency
      MAPPER.createGenerator(new StringWriter());
    } catch (IOException e) {
      throw new UncheckedIOException(e);
    }
  }

  public void to(String who) {
    System.out.println("Hi " + who + "!");
  }
}
