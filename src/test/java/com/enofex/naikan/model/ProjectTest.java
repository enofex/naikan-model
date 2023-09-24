package com.enofex.naikan.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class ProjectTest {

  @Test
  void shouldCreateProject() {
    Project project = createProject();
    assertNotNull(project);
  }

  @Test
  void shouldVerifyProjectFields() {
    Project project = createProject();

    assertAll("Project fields",
        () -> assertEquals("TestProject", project.name()),
        () -> assertEquals("2022", project.inceptionYear()),
        () -> assertEquals("https://example.com/project", project.url()),
        () -> assertEquals("https://example.com/repo", project.repository()),
        () -> assertEquals("jar", project.packaging()),
        () -> assertEquals("com.example", project.groupId()),
        () -> assertEquals("example-project", project.artifactId()),
        () -> assertEquals("1.0.0", project.version()),
        () -> assertEquals("Test project description", project.description()),
        () -> assertEquals("Additional notes", project.notes())
    );
  }

  private Project createProject() {
    return Project.builder()
        .name("TestProject")
        .inceptionYear("2022")
        .url("https://example.com/project")
        .repository("https://example.com/repo")
        .packaging("jar")
        .groupId("com.example")
        .artifactId("example-project")
        .version("1.0.0")
        .description("Test project description")
        .notes("Additional notes")
        .build();
  }
}
