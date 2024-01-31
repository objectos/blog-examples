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
package com.example;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE_USE) @interface A {}

@Target(ElementType.TYPE_USE) @interface B {}

@Target(ElementType.TYPE_USE) @interface C {}

public class Outer {

  class Inner {} static class Nested {}

  // does not compile!
  @A com.example.Outer.Inner a;

  // does not compile!
  com.example.@A Outer.@B Nested b;
  
  // does not compile!
  public @C com.example.Outer c; 
  
}