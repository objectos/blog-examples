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
package post;

public class EmptyStatement {
  public static void main(String[] args) {
    var empty = new EmptyStatement();
    
    // infinite loop...
    //empty.whileInfinity();
    
    empty.forExample(5);
    
    empty.ifStatement(true);
    empty.ifStatement(false);
    empty.ifStatement();
    
    empty.doesNothing();
    
    empty.blocksAndLabels();
    
    empty.doWhile(false);
  }
  
  final void whileInfinity() {
    while (true);
  }
  
  final void forExample(int times) {
    for (int i = 0; i < times; i++);
  }
  
  final void ifStatement(boolean condition) {
    if (condition); else;
  }
  
  final void ifStatement() {
    if (test()) {
      actionOne();
      actionTwo();
    } else;
  }

  final void doWhile(boolean condition) {
    do; while(condition);
  }

  final void doesNothing() {
    ;
    
    ;;
    
    ;;;
  }
  
  @SuppressWarnings("unused")
  final void blocksAndLabels() {
    {; {;} ;; foo:; bar:;}
  }
  
  private void actionTwo() {}

  private void actionOne() {}

  private boolean test() { return false; }
}
