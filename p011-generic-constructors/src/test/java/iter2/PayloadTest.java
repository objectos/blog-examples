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
package iter2;

import static org.testng.Assert.assertEquals;

import java.util.logging.Level;
import org.testng.annotations.Test;

public class PayloadTest {
  @Test
  public void category() {
    var converter = new CategoryConverter();
    var log = new Category(987, "A category");
    var p = new Payload(converter::convert, log);

    assertEquals(p.data(), """
    {
      "id": 987,
      "name": "A category"
    }
    """);
  }

  @Test
  public void log() {
    var converter = new LogConverter();
    var log = new Log(12345L, Level.INFO, "A message");
    var p = new Payload(converter::convert, log);

    assertEquals(p.data(), """
    {
      "millis": 12345,
      "level": "INFO",
      "msg": "A message"
    }
    """);
  }
}