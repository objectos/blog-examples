/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package iter06;

public class HashTable<K, V> extends iter05.HashTable<K, V> {
  @Override
  protected int bucket(Object key) {
    int hc = key.hashCode();

    return Math.floorMod(hc, keys.length);
  }
}