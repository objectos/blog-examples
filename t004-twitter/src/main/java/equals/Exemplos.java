/*
 * Copyright 2023 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package equals;

import java.util.Objects;

public class Exemplos {

  public static class User {
    final String login;

    final String name;

    public User(String login, String name) {
      this.login = Objects.requireNonNull(login);
      this.name = name;
    }

    public final boolean hasName(String name) {
      return Objects.equals(this.name, name);
    }

    public final boolean isFulano() {
      return "Fulano".equals(name);
    }

    public final boolean isRoot() {
      return login.equals("root");
    }
  }

  public void notNull() {

  }

}