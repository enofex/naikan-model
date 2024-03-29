package com.enofex.naikan.model;

import java.util.List;

public final class Teams extends AbstractContainer<Team> {

  private static final Teams NO_TEAMS = new Teams(List.of());

  public Teams(List<Team> teams) {
    super(teams);
  }

  public static Teams empty() {
    return NO_TEAMS;
  }

  public static Teams of(Team... teams) {
    return new Teams(List.of(teams));
  }
}
