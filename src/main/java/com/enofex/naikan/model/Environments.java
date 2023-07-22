package com.enofex.naikan.model;

import java.util.List;

public final class Environments extends AbstractContainer<Environment> {

  private static final Environments NO_ENVIRONMENTS = new Environments(List.of());

  public Environments(List<Environment> environments) {
    super(environments);
  }

  public static Environments empty() {
    return NO_ENVIRONMENTS;
  }
}
