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
package reloader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

public class ClassReloader {

  private final Path classOutput;

  public ClassReloader(Path classOutput) {
    this.classOutput = classOutput;
  }

  public final Class<?> loadClass(String binaryName) throws ClassNotFoundException {
    ThisLoader loader;
    loader = new ThisLoader();

    return loader.loadClass(binaryName);
  }

  private class ThisLoader extends ClassLoader {

    public ThisLoader() {
      super(null); // no parent
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
      try {
        String fileName;
        fileName = name.replace('.', File.separatorChar);

        fileName += ".class";

        Path path;
        path = classOutput.resolve(fileName);

        byte[] bytes;
        bytes = Files.readAllBytes(path);

        return defineClass(name, bytes, 0, bytes.length);
      } catch (NoSuchFileException e) {
        ClassLoader systemLoader;
        systemLoader = ClassLoader.getSystemClassLoader();

        return systemLoader.loadClass(name);
      } catch (IOException e) {
        throw new ClassNotFoundException(name, e);
      }
    }

  }

}