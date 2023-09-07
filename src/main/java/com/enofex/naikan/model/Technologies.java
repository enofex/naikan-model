package com.enofex.naikan.model;

import java.util.List;

public final class Technologies extends AbstractContainer<Technology> {

  private static final Technologies NO_TECHNOLOGIES = new Technologies(List.of());

  public Technologies(List<Technology> technologies) {
    super(technologies);
  }

  public static Technologies empty() {
    return NO_TECHNOLOGIES;
  }

  public static Technologies of(Technology... technologies) {
    return new Technologies(List.of(technologies));
  }
}
