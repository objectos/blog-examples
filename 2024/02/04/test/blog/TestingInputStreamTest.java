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
package blog;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertSame;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestingInputStreamTest {

  @Test
  public void testCase01() {
    try (InputStream is = new TestingInputStream("GET")) {
      byte[] buf;
      buf = new byte[3];

      assertEquals(is.read(buf, 0, 3), 3);
      assertEquals(utf8(buf), "GET");
      assertEquals(is.read(buf), -1);
      assertEquals(is.read(buf), -1);
    } catch (IOException e) {
      Assert.fail("It should not have thrown", e);
    }
  }

  @Test
  public void testCase02() {
    try (InputStream is = new TestingInputStream("GET")) {
      byte[] buf;
      buf = new byte[10];

      assertEquals(is.read(buf), 3);
      assertEquals(utf8(buf, 0, 3), "GET");
      assertEquals(is.read(buf), -1);
      assertEquals(is.read(buf), -1);
    } catch (IOException e) {
      Assert.fail("It should not have thrown", e);
    }
  }

  @Test
  public void testCase03() {
    try (InputStream is = new TestingInputStream("abc123")) {
      byte[] buf;
      buf = new byte[3];

      assertEquals(is.read(buf), 3);
      assertEquals(utf8(buf), "abc");
      assertEquals(is.read(buf), 3);
      assertEquals(utf8(buf), "123");
      assertEquals(is.read(buf), -1);
      assertEquals(is.read(buf), -1);
    } catch (IOException e) {
      Assert.fail("It should not have thrown", e);
    }
  }

  @Test
  public void testCase04() {
    try (InputStream input = new TestingInputStream("abc", "123")) {
      byte[] buf;
      buf = new byte[10];

      assertEquals(input.read(buf), 3);
      assertEquals(utf8(buf, 0, 3), "abc");
      assertEquals(input.read(buf), 3);
      assertEquals(utf8(buf, 0, 3), "123");
      assertEquals(input.read(buf), -1);
      assertEquals(input.read(buf), -1);
    } catch (IOException e) {
      Assert.fail("It should not have thrown", e);
    }
  }

  @Test
  public void testCase05() {
    try (InputStream is = new TestingInputStream("abcde", "12345")) {
      byte[] buf;
      buf = new byte[3];

      assertEquals(is.read(buf), 3);
      assertEquals(utf8(buf, 0, 3), "abc");
      assertEquals(is.read(buf), 2);
      assertEquals(utf8(buf, 0, 2), "de");
      assertEquals(is.read(buf), 3);
      assertEquals(utf8(buf, 0, 3), "123");
      assertEquals(is.read(buf), 2);
      assertEquals(utf8(buf, 0, 2), "45");
      assertEquals(is.read(buf), -1);
      assertEquals(is.read(buf), -1);
    } catch (IOException e) {
      Assert.fail("It should not have thrown", e);
    }
  }

  @Test
  public void testCase06() {
    IOException readError;
    readError = new IOException("On read");

    try (InputStream is = new TestingInputStream("abc", readError)) {
      byte[] buf;
      buf = new byte[3];

      assertEquals(is.read(buf), 3);
      assertEquals(utf8(buf, 0, 3), "abc");
      assertEquals(is.read(buf), 3);

      Assert.fail("It should have thrown");
    } catch (IOException e) {
      assertSame(e, readError);
    }
  }

  @Test
  public void testCase07() {
    IOException closeError;
    closeError = new IOException("On close");

    try (TestingInputStream is = new TestingInputStream("abc", "123")) {
      is.onClose(closeError);

      byte[] buf;
      buf = new byte[3];

      assertEquals(is.read(buf), 3);
      assertEquals(utf8(buf), "abc");
      assertEquals(is.read(buf), 3);
      assertEquals(utf8(buf), "123");
      assertEquals(is.read(buf), -1);
      assertEquals(is.read(buf), -1);
    } catch (IOException e) {
      assertSame(e, closeError);
    }
  }

  @Test
  public void testCase08() {
    byte[] world;
    world = "World".getBytes(StandardCharsets.UTF_8);

    try (InputStream is = new TestingInputStream("Hello", world)) {
      byte[] buf;
      buf = new byte[5];

      assertEquals(is.read(buf), 5);
      assertEquals(utf8(buf), "Hello");
      assertEquals(is.read(buf), 5);
      assertEquals(utf8(buf), "World");
      assertEquals(is.read(buf), -1);
    } catch (IOException e) {
      Assert.fail("It should not have thrown", e);
    }
  }

  @Test
  public void testCase09() {
    try (InputStream src = new TestingInputStream("Hello World!");
        InputStream input = new BufferedInputStream(src);
        ByteArrayOutputStream out = new ByteArrayOutputStream()) {
      int c;

      while ((c = input.read()) != -1) {
        out.write(c);
      }

      byte[] bytes;
      bytes = out.toByteArray();

      assertEquals(utf8(bytes), "Hello World!");
    } catch (IOException e) {
      Assert.fail("It should not have thrown", e);
    }
  }

  private String utf8(byte[] bytes) {
    return new String(bytes, StandardCharsets.UTF_8);
  }

  private String utf8(byte[] bytes, int offset, int len) {
    return new String(bytes, offset, len, StandardCharsets.UTF_8);
  }

}