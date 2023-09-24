package com.enofex.naikan.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class CommitAuthorTest {

  @Test
  void shouldCreateCommitAuthorObject() {
    CommitAuthor commitAuthor = CommitAuthor.builder()
        .name("John Doe")
        .email("john@example.com")
        .build();

    assertNotNull(commitAuthor);
  }

  @Test
  void shouldVerifyCommitAuthorFields() {
    CommitAuthor commitAuthor = CommitAuthor.builder()
        .name("John Doe")
        .email("john@example.com")
        .build();

    assertEquals("John Doe", commitAuthor.name());
    assertEquals("john@example.com", commitAuthor.email());
  }
}
