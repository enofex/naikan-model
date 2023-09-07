package com.enofex.naikan.model;

import java.util.List;

public final class Branches extends AbstractContainer<String> {

  private static final Branches NO_BRANCHES = new Branches(List.of());

  public Branches(List<String> branches) {
    super(branches);
  }

  public static Branches empty() {
    return NO_BRANCHES;
  }

  public static Branches of(String... branches) {
    return new Branches(List.of(branches));
  }
}
