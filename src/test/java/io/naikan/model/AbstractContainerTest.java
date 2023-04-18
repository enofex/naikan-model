package io.naikan.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class AbstractContainerTest {

  @Test
  void shouldReturnAll() {
    List<Integer> entries = List.of(1, 2, 3);
    AbstractContainer<Integer> container = new ConcreteContainer<>(entries);

    assertEquals(entries, container.all());
  }

  @Test
  void shouldReturnLastIndex() {
    List<Integer> entries = List.of(1, 2, 3);
    AbstractContainer<Integer> container = new ConcreteContainer<>(entries);

    assertEquals(2, container.lastIndex());
  }

  @Test
  void shouldHandleEquals() {
    List<Integer> entries = List.of(1, 2, 3);
    AbstractContainer<Integer> container1 = new ConcreteContainer<>(entries);
    AbstractContainer<Integer> container2 = new ConcreteContainer<>(List.of(1, 2, 3));
    AbstractContainer<Integer> container3 = new ConcreteContainer<>(List.of(3, 2, 1));

    assertEquals(container1, container2);
    assertNotEquals(container1, container3);
  }

  @Test
  void shouldHandleHashCode() {
    List<Integer> entries = List.of(1, 2, 3);
    AbstractContainer<Integer> container1 = new ConcreteContainer<>(entries);
    AbstractContainer<Integer> container2 = new ConcreteContainer<>(List.of(1, 2, 3));

    assertEquals(container1.hashCode(), container2.hashCode());
  }

  @Test
  void shouldHandleToString() {
    List<Integer> entries = List.of(1, 2, 3);
    AbstractContainer<Integer> container = new ConcreteContainer<>(entries);

    assertEquals(entries.toString(), container.toString());
  }

  private static final class ConcreteContainer<T> extends AbstractContainer<T> {

    ConcreteContainer(List<T> entries) {
      super(entries);
    }
  }
}
