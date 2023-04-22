package com.enofex.naikan.model;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public abstract class AbstractContainer<T> implements Iterable<T> {

  private final List<T> entries;

  AbstractContainer(List<T> entries) {
    this.entries = entries != null ? entries : List.of();
  }

  public List<T> all() {
    return this.entries;
  }

  public int lastIndex() {
    return this.entries.size() - 1;
  }

  @Override
  public Iterator<T> iterator() {
    return this.entries.iterator();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AbstractContainer<?> that = (AbstractContainer<?>) o;

    return Objects.equals(this.entries, that.entries);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.entries);
  }

  @Override
  public String toString() {
    return Objects.toString(this.entries);
  }
}
