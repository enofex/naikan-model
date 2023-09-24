package com.enofex.naikan.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

class RepositoryTagTest {

  private final RepositoryTag repositoryTag = RepositoryTag.builder()
      .name("TestTag")
      .timestamp(LocalDateTime.now())
      .build();

  @Test
  void shouldCreateRepositoryTagObject() {
    assertNotNull(this.repositoryTag);
  }

  @Test
  void shouldVerifyRepositoryTagFields() {
    assertAll("RepositoryTag fields",
        () -> assertEquals("TestTag", this.repositoryTag.name()),
        () -> assertNotNull(this.repositoryTag.timestamp())
    );
  }

  @Test
  void shouldCreateRepositoryTagWithBuilder() {
    LocalDateTime now = LocalDateTime.now();
    RepositoryTag.Builder builder = RepositoryTag.builder()
        .name("BuilderTestTag")
        .timestamp(now);

    RepositoryTag builtRepositoryTag = builder.build();

    assertAll("RepositoryTag fields",
        () -> assertEquals("BuilderTestTag", builtRepositoryTag.name()),
        () -> assertEquals(now, builtRepositoryTag.timestamp())
    );
  }
}
