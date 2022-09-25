/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package iter12;

public class HashTable<K, V> extends iter11.HashTable<K, V> {
  @Override
  protected final V put2(K key, V value, int bucket) {
    for (var index = bucket + 1; index < keys.length; index++) {
      var existing = keys[index];

      if (existing == null) {
        return putInsert(key, value, index);
      }

      if (existing.equals(key)) {
        return putReplace(key, value, index);
      }
    }

    for (var index = 0; index < bucket; index++) {
      var existing = keys[index];

      if (existing == null) {
        return putInsert(key, value, index);
      }

      if (existing.equals(key)) {
        return putReplace(key, value, index);
      }
    }

    return put3(key, value, bucket);
  }

  private V put3(K key, V value, int bucket) {
    throw new AssertionError("Load factor not implemented?");
  }
}