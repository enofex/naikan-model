package com.enofex.naikan.model.deserializer.json;


import static com.enofex.naikan.test.model.Boms.validBom0asInputStream;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.enofex.naikan.model.Bom;
import com.enofex.naikan.model.deserializer.DeserializerException;
import com.enofex.naikan.model.deserializer.DeserializerFactory;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

class JsonDeserializerTest {

  @Test
  void shouldDeserializeValidModel() throws DeserializerException {
    Bom bom = DeserializerFactory.newJsonDeserializer().of(validBom0asInputStream());

    assertAll(() -> assertNull(bom.id()), () -> assertEquals("Naikan", bom.bomFormat()),
        () -> assertEquals("1.0", bom.specVersion()),
        () -> assertEquals(LocalDateTime.parse("2022-12-29T08:29:10.079226"), bom.timestamp()),

        () -> assertEquals("Naikan I", bom.project().name()),
        () -> assertEquals("2003", bom.project().inceptionYear()),
        () -> assertEquals("https://naikan.io", bom.project().url()),
        () -> assertEquals("https://github.com/enofex/naikan-projects", bom.project().repository()),
        () -> assertEquals("jar", bom.project().packaging()),
        () -> assertEquals("com.enofex", bom.project().groupId()),
        () -> assertEquals("naikan-core", bom.project().artifactId()),
        () -> assertEquals("1.0.0", bom.project().version()),
        () -> assertEquals("Naikan core module", bom.project().description()),
        () -> assertEquals("Naikan notes", bom.project().notes()),

        () -> assertEquals("Naikan", bom.organization().name()),
        () -> assertEquals("https://naikan.io", bom.organization().url()),
        () -> assertEquals("Software department", bom.organization().department()),
        () -> assertEquals("Company projects at a glance", bom.organization().description()),

        () -> assertEquals(2, bom.environments().all().size()),
        () -> assertEquals("Staging", bom.environments().all().getFirst().name()),
        () -> assertEquals("Staging description",
            bom.environments().all().getFirst().description()),
        () -> assertEquals("staging.naikan.io", bom.environments().all().getFirst().location()),
        () -> assertEquals(1, bom.environments().all().getFirst().tags().all().size()),
        () -> assertEquals("Staging", bom.environments().all().getFirst().tags().all().getFirst()),
        () -> assertEquals("Production", bom.environments().all().get(1).name()),
        () -> assertEquals("Production description", bom.environments().all().get(1).description()),
        () -> assertEquals("naikan.io", bom.environments().all().get(1).location()),
        () -> assertEquals(0, bom.environments().all().get(1).tags().all().size()),

        () -> assertEquals(1, bom.teams().all().size()),
        () -> assertEquals("Naikan Team", bom.teams().all().getFirst().name()),
        () -> assertEquals("Naikan Core Team", bom.teams().all().getFirst().description()),

        () -> assertEquals(1, bom.developers().all().size()),
        () -> assertEquals("Trev Cooksey", bom.developers().all().getFirst().name()),
        () -> assertEquals("cytrev", bom.developers().all().getFirst().username()),
        () -> assertEquals("Principal Software Engineer",
            bom.developers().all().getFirst().title()),
        () -> assertEquals("Naikan Software Engineering",
            bom.developers().all().getFirst().department()),
        () -> assertEquals("tcooksey1@geocities.jp", bom.developers().all().getFirst().email()),
        () -> assertEquals("1212-12-90999", bom.developers().all().getFirst().phone()),
        () -> assertEquals("Edgetag", bom.developers().all().getFirst().organization()),
        () -> assertEquals("https://www.edgetag.tech",
            bom.developers().all().getFirst().organizationUrl()),
        () -> assertEquals("America/New_York", bom.developers().all().getFirst().timezone()),
        () -> assertEquals("Best developer!", bom.developers().all().getFirst().description()),
        () -> assertEquals(2, bom.developers().all().getFirst().roles().all().size()),
        () -> assertEquals("architect", bom.developers().all().getFirst().roles().all().getFirst()),
        () -> assertEquals("developer", bom.developers().all().getFirst().roles().all().get(1)),

        () -> assertEquals(1, bom.contacts().all().size()),
        () -> assertEquals("John Doe", bom.contacts().all().getFirst().name()),
        () -> assertEquals("Product Owner", bom.contacts().all().getFirst().title()),
        () -> assertEquals("jdoe@example.com", bom.contacts().all().getFirst().email()),
        () -> assertEquals("461-355-2912", bom.contacts().all().getFirst().phone()),
        () -> assertEquals("Responsible for this project",
            bom.contacts().all().getFirst().description()),
        () -> assertEquals("PO", bom.contacts().all().getFirst().roles().all().getFirst()),

        () -> assertEquals(2, bom.technologies().all().size()),
        () -> assertEquals("Java", bom.technologies().all().getFirst().name()),
        () -> assertEquals("19", bom.technologies().all().getFirst().version()),
        () -> assertEquals(1, bom.technologies().all().getFirst().tags().all().size()),
        () -> assertEquals("backend", bom.technologies().all().getFirst().tags().all().getFirst()),
        () -> assertEquals("Angular", bom.technologies().all().get(1).name()),
        () -> assertEquals("React or Angular", bom.technologies().all().get(1).description()),
        () -> assertEquals("15.0", bom.technologies().all().get(1).version()),
        () -> assertEquals("Best programming language",
            bom.technologies().all().getFirst().description()),

        () -> assertEquals(1, bom.licenses().all().size()),
        () -> assertEquals("Apache-2.0", bom.licenses().all().getFirst().name()),
        () -> assertEquals("https://www.apache.org/licenses/LICENSE-2.0.txt",
            bom.licenses().all().getFirst().url()),
        () -> assertEquals("Or MIT license?", bom.licenses().all().getFirst().description()),

        () -> assertEquals(2, bom.documentations().all().size()),
        () -> assertEquals("Architecture overview", bom.documentations().all().getFirst().name()),
        () -> assertEquals("naikan.io/arch24", bom.documentations().all().getFirst().location()),
        () -> assertEquals("ARC24", bom.documentations().all().getFirst().description()),
        () -> assertEquals(2, bom.documentations().all().getFirst().tags().all().size()),
        () -> assertEquals("Architecture",
            bom.documentations().all().getFirst().tags().all().getFirst()),
        () -> assertEquals("ARC24", bom.documentations().all().getFirst().tags().all().get(1)),
        () -> assertEquals("Technical debt", bom.documentations().all().get(1).name()),
        () -> assertEquals("wiki.naikan.io/techdebt", bom.documentations().all().get(1).location()),
        () -> assertEquals("Should be reduced!", bom.documentations().all().get(1).description()),

        () -> assertEquals(5, bom.integrations().all().size()),
        () -> assertEquals("Bitbucket", bom.integrations().all().getFirst().name()),
        () -> assertEquals("Scm description", bom.integrations().all().getFirst().description()),
        () -> assertEquals("http://127.0.0.1/bitbucket/naikan",
            bom.integrations().all().getFirst().url()),
        () -> assertEquals(1, bom.integrations().all().getFirst().tags().all().size()),
        () -> assertEquals("Scm", bom.integrations().all().getFirst().tags().all().getFirst()),
        () -> assertEquals("Bamboo", bom.integrations().all().get(1).name()),
        () -> assertEquals("Ci description", bom.integrations().all().get(1).description()),
        () -> assertEquals("http://127.0.0.1:8080/bamboo/naikan",
            bom.integrations().all().get(1).url()),
        () -> assertEquals("Jira", bom.integrations().all().get(2).name()),
        () -> assertEquals("JDD", bom.integrations().all().get(2).description()),
        () -> assertEquals("http://127.0.0.1/jira/naikan", bom.integrations().all().get(2).url()),
        () -> assertEquals("SonarQube", bom.integrations().all().get(3).name()),
        () -> assertEquals("Great tools!", bom.integrations().all().get(3).description()),
        () -> assertEquals("http://127.0.0.1/sonar/naikan", bom.integrations().all().get(3).url()),
        () -> assertEquals("DependencyTrack", bom.integrations().all().get(4).name()),
        () -> assertEquals("Must have!", bom.integrations().all().get(4).description()),
        () -> assertEquals("http://127.0.0.1/dtrack/naikan", bom.integrations().all().get(4).url()),

        () -> assertEquals(2, bom.tags().all().size()),
        () -> assertEquals("web", bom.tags().all().getFirst()),
        () -> assertEquals("intern", bom.tags().all().get(1)),

        () -> assertEquals(2, bom.deployments().all().size()),
        () -> assertEquals("Staging", bom.deployments().all().getFirst().environment()),
        () -> assertEquals("staging.naikan.io", bom.deployments().all().getFirst().location()),
        () -> assertEquals("1.0.0", bom.deployments().all().getFirst().version()),
        () -> assertEquals(LocalDateTime.parse("2022-12-28T08:29:10.079226"),
            bom.deployments().all().getFirst().timestamp()),

        () -> assertEquals("naikan", bom.repository().name()),
        () -> assertEquals("git@github.com:enofex/naikan.git", bom.repository().url()),
        () -> assertEquals("4c2f7dbfab5aa133bab1ca8d0a09a49e3713e25a",
            bom.repository().firstCommit().commitId()),
        () -> assertEquals(LocalDateTime.parse("2023-07-13T17:41:08"),
            bom.repository().firstCommit().timestamp()),
        () -> assertEquals("Init commit",
            bom.repository().firstCommit().shortMessage()),
        () -> assertEquals("Trev Cooksey",
            bom.repository().firstCommit().author().name()),
        () -> assertEquals("tcooksey1@geocities.jp",
            bom.repository().firstCommit().author().email()),
        () -> assertEquals(46856,
            bom.repository().firstCommit().changes().lines().added()),
        () -> assertEquals(0,
            bom.repository().firstCommit().changes().lines().deleted()),
        () -> assertEquals(350,
            bom.repository().firstCommit().changes().files().added()),
        () -> assertEquals(0,
            bom.repository().firstCommit().changes().files().deleted()),
        () -> assertEquals(0,
            bom.repository().firstCommit().changes().files().changed()),
        () -> assertEquals(3, bom.repository().totalCommits()),
        () -> assertEquals("main", bom.repository().defaultBranch()),
        () -> assertEquals(3, bom.repository().tags().all().size()),
        () -> assertEquals(3, bom.repository().branches().all().size()),
        () -> assertEquals(3, bom.repository().commits().all().size())
    );
  }
}
