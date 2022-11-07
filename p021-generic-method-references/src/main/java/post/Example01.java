/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package post;

public class Example01 {
  public static void main(String[] args) {
    var serializer = new Serializer<>(CityConverter.INSTANCE::convert);

    var sp = new State("SP");

    serializer.addItem(sp.newCity("São Paulo"));
    serializer.addItem(sp.newCity("Guarujá"));

    var rj = new State("RJ");

    serializer.addItem(rj.newCity("Rio de Janeiro"));
    serializer.addItem(rj.newCity("Petrópolis"));

    var result = serializer.toPayload(Payload::<City> new);

    System.out.println(result);
  }
}
