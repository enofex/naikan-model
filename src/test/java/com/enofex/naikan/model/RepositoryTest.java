package com.enofex.naikan.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class RepositoryTest {

  @Test
  void shouldCreateRepository() {
    Repository repository = createRepository();
    assertNotNull(repository);
  }

  @Test
  void shouldVerifyRepositoryFields() {
    Repository repository = createRepository();

    assertAll("Repository fields",
        () -> assertEquals("TestRepository", repository.name()),
        () -> assertEquals("https://example.com/repo", repository.url()),
        () -> assertNotNull(repository.firstCommit()),
        () -> assertEquals(10, repository.totalCommits()),
        () -> assertEquals("main", repository.defaultBranch())
    );
  }

  private Repository createRepository() {
    Commit firstCommit = Commit.builder()
        .commitId("123456")
        .timestamp(null)
        .shortMessage("Initial commit")
        .author(null)
        .changes(null)
        .build();

    return Repository.builder()
        .name("TestRepository")
        .url("https://example.com/repo")
        .firstCommit(firstCommit)
        .totalCommits(10)
        .defaultBranch("main")
        .branches(null)
        .tags(null)
        .commits(null)
        .build();
  }
}
