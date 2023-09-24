package com.enofex.naikan.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

class BomTest {

  @Test
  void shouldCreateBom() {
    Bom bom = createBom();
    assertNotNull(bom);
  }

  @Test
  void shouldVerifyBomFields() {
    Bom bom = createBom();

    assertAll("Bom fields",
        () -> assertEquals("TestBomId", bom.id()),
        () -> assertEquals("Naikan", bom.bomFormat()),
        () -> assertEquals("1.0", bom.specVersion()),
        () -> assertNotNull(bom.timestamp()),
        () -> assertNotNull(bom.project()),
        () -> assertNotNull(bom.organization()),
        () -> assertNotNull(bom.environments()),
        () -> assertNotNull(bom.teams()),
        () -> assertNotNull(bom.developers()),
        () -> assertNotNull(bom.contacts()),
        () -> assertNotNull(bom.technologies()),
        () -> assertNotNull(bom.licenses()),
        () -> assertNotNull(bom.documentations()),
        () -> assertNotNull(bom.integrations()),
        () -> assertNotNull(bom.tags()),
        () -> assertNotNull(bom.deployments()),
        () -> assertNotNull(bom.repository())
    );
  }

  private Bom createBom() {
    return Bom.builder()
        .id("TestBomId")
        .specVersion("1.0")
        .project(new Project(
            "TestProject",
            "2022",
            "https://example.com/project",
            "https://example.com/repo",
            "jar",
            "com.example",
            "example-project",
            "1.0.0",
            "Test project description", "Additional notes"))
        .organization(new Organization(
            "TestOrg",
            "https://example.com/org",
            "TestDept",
            "Org description"))
        .environments(Environments.of(new Environment(
            "Env1",
            "Location1",
            "Env description",
            Tags.of("tag1"))))
        .teams(Teams.of(new Team("Team1", "Team description")))
        .developers(Developers.of(new Developer(
            "Dev1",
            "dev1",
            "Dev Title",
            "Dev Dept",
            "dev@example.com",
            "123-456-7890",
            "Org1",
            "https://example.com/org1",
            "Timezone1",
            "Dev description",
            Roles.of("role1"))))
        .contacts(Contacts.of(new Contact(
            "Contact1",
            "Title1",
            "contact@example.com",
            "123-456-7890",
            "Contact description",
            Roles.of("role1"))))
        .technologies(Technologies.of(new Technology(
            "Tech1",
            "1.0",
            "Tech description",
            Tags.of("tag1"))))
        .licenses(Licenses.of(new License(
            "License1",
            "https://example.com/license",
            "License description")))
        .documentations(Documentations.of(new Documentation(
            "Doc1",
            "https://example.com/doc",
            "Doc description",
            Tags.of("tag1"))))
        .integrations(Integrations.of(new Integration(
            "Integration1",
            "https://example.com/integration",
            "Integration description",
            Tags.of("tag1"))))
        .tags(Tags.of("tag1"))
        .deployments(Deployments.of(new Deployment(
            "Env1",
            "Location1",
            "1.0.0",
            LocalDateTime.now())))
        .repository(new Repository(
            "Repo1",
            "https://example.com/repo1",
            new Commit(
                "Commit1",
                LocalDateTime.now(),
                "Short message",
                new CommitAuthor("Author1", "author@example.com"),
                new CommitChanges(
                    new CommitLinesChanges(1, 2),
                    new CommitFilesChanges(3, 4, 5))
            ),
            20,
            "main",
            Branches.empty(),
            RepositoryTags.empty(),
            Commits.empty())
        ).build();
  }
}
