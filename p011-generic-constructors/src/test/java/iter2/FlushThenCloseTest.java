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

import java.io.IOException;
import java.util.List;
import org.testng.annotations.Test;
import shared.CanCloseAndFlush;
import shared.CanCloseAndFlush.Operation;

public class FlushThenCloseTest {
  @Test
  public void execute() throws IOException {
    var subject = new CanCloseAndFlush();

    var wrapper = new FlushThenClose(subject);

    wrapper.execute();

    assertEquals(
      subject.operations,
      List.of(Operation.FLUSH, Operation.CLOSE)
    );
  }
}