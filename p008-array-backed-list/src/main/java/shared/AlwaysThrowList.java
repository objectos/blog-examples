/*
 * Copyright 2022 Objectos Software LTDA.
 *
 * Reprodução parcial ou total proibida.
 */
package shared;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public abstract class AlwaysThrowList<E> implements List<E> {
  protected AlwaysThrowList() {}

  @Override
  public boolean add(E e) {
    throw new UnsupportedOperationException("Implement me");
  }

  @Override
  public void add(int index, E element) {
    throw new UnsupportedOperationException("Implement me");
  }

  @Override
  public boolean addAll(Collection<? extends E> c) {
    throw new UnsupportedOperationException("Implement me");
  }

  @Override
  public boolean addAll(int index, Collection<? extends E> c) {
    throw new UnsupportedOperationException("Implement me");
  }

  @Override
  public void clear() {
    throw new UnsupportedOperationException("Implement me");
  }

  @Override
  public boolean contains(Object o) {
    throw new UnsupportedOperationException("Implement me");
  }

  @Override
  public boolean containsAll(Collection<?> c) {
    throw new UnsupportedOperationException("Implement me");
  }

  @Override
  public E get(int index) {
    throw new UnsupportedOperationException("Implement me");
  }

  @Override
  public int indexOf(Object o) {
    throw new UnsupportedOperationException("Implement me");
  }

  @Override
  public boolean isEmpty() {
    throw new UnsupportedOperationException("Implement me");
  }

  @Override
  public Iterator<E> iterator() {
    throw new UnsupportedOperationException("Implement me");
  }

  @Override
  public int lastIndexOf(Object o) {
    throw new UnsupportedOperationException("Implement me");
  }

  @Override
  public ListIterator<E> listIterator() {
    throw new UnsupportedOperationException("Implement me");
  }

  @Override
  public ListIterator<E> listIterator(int index) {
    throw new UnsupportedOperationException("Implement me");
  }

  @Override
  public E remove(int index) {
    throw new UnsupportedOperationException("Implement me");
  }

  @Override
  public boolean remove(Object o) {
    throw new UnsupportedOperationException("Implement me");
  }

  @Override
  public boolean removeAll(Collection<?> c) {
    throw new UnsupportedOperationException("Implement me");
  }

  @Override
  public boolean retainAll(Collection<?> c) {
    throw new UnsupportedOperationException("Implement me");
  }

  @Override
  public E set(int index, E element) {
    throw new UnsupportedOperationException("Implement me");
  }

  @Override
  public int size() {
    throw new UnsupportedOperationException("Implement me");
  }

  @Override
  public List<E> subList(int fromIndex, int toIndex) {
    throw new UnsupportedOperationException("Implement me");
  }

  @Override
  public Object[] toArray() {
    throw new UnsupportedOperationException("Implement me");
  }

  @Override
  public <T> T[] toArray(T[] a) {
    throw new UnsupportedOperationException("Implement me");
  }
}