package com.enofex.naikan.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

class CommitTest {

  @Test
  void shouldCreateCommitObject() {
    CommitAuthor author = CommitAuthor.builder()
        .name("John Doe")
        .email("john@example.com")
        .build();

    CommitChanges changes = CommitChanges.builder()
        .lines(10, 5)
        .files(10, 5, 3)
        .build();

    Commit commit = Commit.builder()
        .commitId("12345")
        .timestamp(LocalDateTime.of(2023, 9, 24, 12, 0))
        .shortMessage("Test commit")
        .author(author)
        .changes(changes)
        .build();

    assertNotNull(commit);
  }

  @Test
  void shouldVerifyCommitFields() {
    CommitAuthor author = CommitAuthor.builder()
        .name("John Doe")
        .email("john@example.com")
        .build();

    CommitChanges changes = CommitChanges.builder()
        .lines(10, 5)
        .files(10, 5, 3)
        .build();

    Commit commit = Commit.builder()
        .commitId("12345")
        .timestamp(LocalDateTime.of(2023, 9, 24, 12, 0))
        .shortMessage("Test commit")
        .author(author)
        .changes(changes)
        .build();

    assertEquals("12345", commit.commitId());
    assertEquals(LocalDateTime.of(2023, 9, 24, 12, 0), commit.timestamp());
    assertEquals("Test commit", commit.shortMessage());
    assertEquals(author, commit.author());
    assertEquals(changes, commit.changes());
  }
}
