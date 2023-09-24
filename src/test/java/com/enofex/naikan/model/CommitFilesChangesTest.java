package com.enofex.naikan.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class CommitFilesChangesTest {

  @Test
  void shouldCreateCommitFilesChangesObject() {
    CommitFilesChanges commitFilesChanges = CommitFilesChanges.builder()
        .added(10)
        .deleted(5)
        .changed(3)
        .build();

    assertNotNull(commitFilesChanges);
  }

  @Test
  void shouldVerifyCommitFilesChangesFields() {
    CommitFilesChanges commitFilesChanges = CommitFilesChanges.builder()
        .added(10)
        .deleted(5)
        .changed(3)
        .build();

    assertEquals(10, commitFilesChanges.added());
    assertEquals(5, commitFilesChanges.deleted());
    assertEquals(3, commitFilesChanges.changed());
  }
}
