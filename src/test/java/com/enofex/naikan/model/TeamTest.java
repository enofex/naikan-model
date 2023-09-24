package com.enofex.naikan.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class TeamTest {

  private final Team team = Team.builder()
      .name("TestTeam")
      .description("TestDescription")
      .build();

  @Test
  void shouldCreateTeamObject() {
    assertNotNull(this.team);
  }

  @Test
  void shouldVerifyTeamFields() {
    assertAll("Team fields",
        () -> assertEquals("TestTeam", this.team.name()),
        () -> assertEquals("TestDescription", this.team.description())
    );
  }

  @Test
  void shouldCreateTeamWithBuilder() {
    Team.Builder builder = Team.builder()
        .name("BuilderTestTeam")
        .description("BuilderTestDescription");

    Team builtTeam = builder.build();

    assertAll("Team fields",
        () -> assertEquals("BuilderTestTeam", builtTeam.name()),
        () -> assertEquals("BuilderTestDescription", builtTeam.description())
    );
  }
}
