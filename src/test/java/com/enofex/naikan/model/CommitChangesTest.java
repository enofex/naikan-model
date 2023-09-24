package com.enofex.naikan.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class CommitChangesTest {

  @Test
  void shouldCreateCommitChangesObject() {
    CommitChanges commitChanges = CommitChanges.builder()
        .lines(10, 5)
        .files(5, 3, 2)
        .build();

    assertNotNull(commitChanges);
  }

  @Test
  void shouldVerifyCommitChangesFields() {
    CommitChanges commitChanges = CommitChanges.builder()
        .lines(10, 5)
        .files(5, 3, 2)
        .build();

    assertEquals(10, commitChanges.lines().added());
    assertEquals(5, commitChanges.lines().deleted());
    assertEquals(5, commitChanges.files().added());
    assertEquals(3, commitChanges.files().deleted());
    assertEquals(2, commitChanges.files().changed());
  }
}
