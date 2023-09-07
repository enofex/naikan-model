package com.enofex.naikan.model;

import java.util.List;

public final class Integrations extends AbstractContainer<Integration> {

  private static final Integrations NO_INTEGRATIONS = new Integrations(List.of());

  public Integrations(List<Integration> integrations) {
    super(integrations);
  }

  public static Integrations empty() {
    return NO_INTEGRATIONS;
  }

  public static Integrations of(Integration... integrations) {
    return new Integrations(List.of(integrations));
  }
}
