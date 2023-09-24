package com.enofex.naikan.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class CommitsTest {

  @Test
  void shouldCreateCommitsWithEntries() {
    Commit commit1 = createCommit("commit1", LocalDateTime.of(2023, 1, 1, 0, 0));
    Commit commit2 = createCommit("commit2", LocalDateTime.of(2023, 2, 1, 0, 0));
    Commit commit3 = createCommit("commit3", LocalDateTime.of(2023, 3, 1, 0, 0));
    List<Commit> commits = Arrays.asList(commit2, commit3, commit1);

    Commits commitsContainer = new Commits(commits);

    List<Commit> expectedCommits = Arrays.asList(commit1, commit2, commit3);
    assertEquals(expectedCommits, commitsContainer.all());
  }

  @Test
  void shouldCreateEmptyCommits() {
    Commits commitsContainer = Commits.empty();
    assertTrue(commitsContainer.all().isEmpty());
  }

  @Test
  void shouldCreateCommitsUsingOf() {
    Commit commitA = createCommit("commitA", LocalDateTime.of(2023, 1, 1, 0, 0));
    Commit commitB = createCommit("commitB", LocalDateTime.of(2023, 2, 1, 0, 0));
    Commit commitC = createCommit("commitC", LocalDateTime.of(2023, 3, 1, 0, 0));

    Commits commitsContainer = Commits.of(commitB, commitA, commitC);

    List<Commit> expectedCommits = Arrays.asList(commitA, commitB, commitC);
    assertEquals(expectedCommits, commitsContainer.all());
  }

  @Test
  void shouldCreateCommitsWithDuplicates() {
    Commit commit1 = createCommit("commit1", LocalDateTime.of(2023, 1, 1, 0, 0));
    List<Commit> commitsWithDuplicates = Arrays.asList(commit1, commit1);

    Commits commitsContainer = new Commits(commitsWithDuplicates);

    List<Commit> expectedCommits = Arrays.asList(commit1, commit1);
    assertEquals(expectedCommits, commitsContainer.all());
  }

  @Test
  void shouldVerifyEmptyCommitsSize() {
    Commits commitsContainer = Commits.empty();
    assertEquals(0, commitsContainer.all().size());
  }

  private Commit createCommit(String commitId, LocalDateTime timestamp) {
    return Commit.builder()
        .commitId(commitId)
        .timestamp(timestamp)
        .build();
  }
}
