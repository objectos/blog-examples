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
package cce;

public class CustomClassLoaderTest {
  public static void main(String[] args) throws Exception {
    var ourLoader = new CustomClassLoader();

    ourLoader.put("cce.ClsCircErr01", Data.CLASS_01);
    ourLoader.put("cce.ClsCircErr02", Data.CLASS_02);
    ourLoader.put("cce.ClsCircErr03", Data.CLASS_03);

    System.out.println("new ClsCirErr03()");
    ourLoader.newInstance("cce.ClsCircErr03");
  }
}