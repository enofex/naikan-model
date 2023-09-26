package com.enofex.naikan.model;

import java.util.List;

public final class Branches extends AbstractContainer<Branch> {

  private static final Branches NO_BRANCHES = new Branches(List.of());

  public Branches(List<Branch> branches) {
    super(branches);
  }

  public static Branches empty() {
    return NO_BRANCHES;
  }

  public static Branches of(Branch... branches) {
    return new Branches(List.of(branches));
  }
}
