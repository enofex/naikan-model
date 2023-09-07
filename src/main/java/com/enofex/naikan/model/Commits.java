package com.enofex.naikan.model;

import java.util.Comparator;
import java.util.List;

public final class Commits extends AbstractContainer<Commit> {

  private static final Commits NO_COMMITS = new Commits(List.of());

  public Commits(List<Commit> commits) {
    super(commits != null
        ? commits.stream().sorted(Comparator.comparing(Commit::timestamp)).toList()
        : List.of());
  }

  public static Commits empty() {
    return NO_COMMITS;
  }

  public static Commits of(Commit... commits) {
    return new Commits(List.of(commits));
  }
}
