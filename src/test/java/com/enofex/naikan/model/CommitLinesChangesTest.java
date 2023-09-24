package com.enofex.naikan.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class CommitLinesChangesTest {

  @Test
  void shouldCreateCommitLinesChangesObject() {
    CommitLinesChanges commitLinesChanges = CommitLinesChanges.builder()
        .added(10)
        .deleted(5)
        .build();

    assertNotNull(commitLinesChanges);
  }

  @Test
  void shouldVerifyCommitLinesChangesFields() {
    CommitLinesChanges commitLinesChanges = CommitLinesChanges.builder()
        .added(10)
        .deleted(5)
        .build();

    assertEquals(10, commitLinesChanges.added());
    assertEquals(5, commitLinesChanges.deleted());
  }
}
