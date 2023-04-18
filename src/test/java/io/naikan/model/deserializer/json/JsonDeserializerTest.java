package io.naikan.model.deserializer.json;

import static io.naikan.test.model.Boms.validBom0asInputStream;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import io.naikan.model.Bom;
import io.naikan.model.deserializer.DeserializerException;
import io.naikan.model.deserializer.DeserializerFactory;

class JsonDeserializerTest {

  @Test
  void shouldDeserializeValidModel() throws DeserializerException {
    Bom bom = DeserializerFactory.newJsonDeserializer().of(validBom0asInputStream());

    assertAll(
        () -> assertNull(bom.id()),
        () -> assertEquals("Naikan", bom.bomFormat()),
        () -> assertEquals("1.0", bom.specVersion()),
        () -> assertEquals(LocalDateTime.parse("2022-12-29T08:29:10.079226"), bom.timestamp()),

        () -> assertEquals("Naikan I", bom.project().name()),
        () -> assertEquals("https://naikan.io", bom.project().url()),
        () -> assertEquals("https://github.com/naikan-projects", bom.project().repository()),
        () -> assertEquals("jar", bom.project().packaging()),
        () -> assertEquals("io.naikan", bom.project().groupId()),
        () -> assertEquals("naikan-core", bom.project().artifactId()),
        () -> assertEquals("1.0.0", bom.project().version()),
        () -> assertEquals("Naikan core module", bom.project().description()),
        () -> assertEquals("Naikan notes", bom.project().notes()),

        () -> assertEquals("Naikan", bom.organization().name()),
        () -> assertEquals("https://naikan.io", bom.organization().url()),
        () -> assertEquals("Software department", bom.organization().department()),
        () -> assertEquals("Company projects at a glance", bom.organization().description()),

        () -> assertEquals(2, bom.environments().all().size()),
        () -> assertEquals("Staging", bom.environments().all().get(0).name()),
        () -> assertEquals("Staging description", bom.environments().all().get(0).description()),
        () -> assertEquals("staging.naikan.io", bom.environments().all().get(0).location()),
        () -> assertEquals(1, bom.environments().all().get(0).tags().all().size()),
        () -> assertEquals("Staging", bom.environments().all().get(0).tags().all().get(0)),
        () -> assertEquals("Production", bom.environments().all().get(1).name()),
        () -> assertEquals("Production description", bom.environments().all().get(1).description()),
        () -> assertEquals("naikan.io", bom.environments().all().get(1).location()),
        () -> assertEquals(0, bom.environments().all().get(1).tags().all().size()),

        () -> assertEquals(1, bom.teams().all().size()),
        () -> assertEquals("Naikan Team", bom.teams().all().get(0).name()),
        () -> assertEquals("Naikan Core Team", bom.teams().all().get(0).description()),

        () -> assertEquals(1, bom.developers().all().size()),
        () -> assertEquals("Trev Cooksey", bom.developers().all().get(0).name()),
        () -> assertEquals("Principal Software Engineer", bom.developers().all().get(0).title()),
        () -> assertEquals("Naikan Software Engineering",
            bom.developers().all().get(0).department()),
        () -> assertEquals("tcooksey1@geocities.jp", bom.developers().all().get(0).email()),
        () -> assertEquals("1212-12-90999", bom.developers().all().get(0).phone()),
        () -> assertEquals("Edgetag", bom.developers().all().get(0).organization()),
        () -> assertEquals("https://www.edgetag.tech",
            bom.developers().all().get(0).organizationUrl()),
        () -> assertEquals("America/New_York", bom.developers().all().get(0).timezone()),
        () -> assertEquals("Best developer!", bom.developers().all().get(0).description()),
        () -> assertEquals(2, bom.developers().all().get(0).roles().all().size()),
        () -> assertEquals("architect", bom.developers().all().get(0).roles().all().get(0)),
        () -> assertEquals("developer", bom.developers().all().get(0).roles().all().get(1)),

        () -> assertEquals(1, bom.contacts().all().size()),
        () -> assertEquals("John Doe", bom.contacts().all().get(0).name()),
        () -> assertEquals("Product Owner", bom.contacts().all().get(0).title()),
        () -> assertEquals("jdoe@example.com", bom.contacts().all().get(0).email()),
        () -> assertEquals("461-355-2912", bom.contacts().all().get(0).phone()),
        () -> assertEquals("Responsible for this project",
            bom.contacts().all().get(0).description()),
        () -> assertEquals("PO", bom.contacts().all().get(0).roles().all().get(0)),

        () -> assertEquals(2, bom.technologies().all().size()),
        () -> assertEquals("Java", bom.technologies().all().get(0).name()),
        () -> assertEquals("19", bom.technologies().all().get(0).version()),
        () -> assertEquals(1, bom.technologies().all().get(0).tags().all().size()),
        () -> assertEquals("backend", bom.technologies().all().get(0).tags().all().get(0)),
        () -> assertEquals("Angular", bom.technologies().all().get(1).name()),
        () -> assertEquals("React or Angular", bom.technologies().all().get(1).description()),
        () -> assertEquals("15.0", bom.technologies().all().get(1).version()),
        () -> assertEquals("Best programming language",
            bom.technologies().all().get(0).description()),

        () -> assertEquals(1, bom.licenses().all().size()),
        () -> assertEquals("Apache-2.0", bom.licenses().all().get(0).name()),
        () -> assertEquals("https://www.apache.org/licenses/LICENSE-2.0.txt",
            bom.licenses().all().get(0).url()),
        () -> assertEquals("Or MIT license?", bom.licenses().all().get(0).description()),

        () -> assertEquals(2, bom.documentations().all().size()),
        () -> assertEquals("Architecture overview", bom.documentations().all().get(0).name()),
        () -> assertEquals("naikan.io/arch24", bom.documentations().all().get(0).location()),
        () -> assertEquals("ARC24", bom.documentations().all().get(0).description()),
        () -> assertEquals(2, bom.documentations().all().get(0).tags().all().size()),
        () -> assertEquals("Architecture", bom.documentations().all().get(0).tags().all().get(0)),
        () -> assertEquals("ARC24", bom.documentations().all().get(0).tags().all().get(1)),
        () -> assertEquals("Technical dept", bom.documentations().all().get(1).name()),
        () -> assertEquals("wiki.naikan.io/techdept", bom.documentations().all().get(1).location()),
        () -> assertEquals("Should be reduced!", bom.documentations().all().get(1).description()),

        () -> assertEquals(5, bom.integrations().all().size()),
        () -> assertEquals("Bitbucket", bom.integrations().all().get(0).name()),
        () -> assertEquals("Scm description", bom.integrations().all().get(0).description()),
        () -> assertEquals("http://127.0.0.1/bitbucket/naikan",
            bom.integrations().all().get(0).url()),
        () -> assertEquals(1, bom.integrations().all().get(0).tags().all().size()),
        () -> assertEquals("Scm", bom.integrations().all().get(0).tags().all().get(0)),
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
        () -> assertEquals("web", bom.tags().all().get(0)),
        () -> assertEquals("intern", bom.tags().all().get(1)),

        () -> assertEquals(2, bom.deployments().all().size()),
        () -> assertEquals("Staging", bom.deployments().all().get(0).environment()),
        () -> assertEquals("staging.naikan.io", bom.deployments().all().get(0).location()),
        () -> assertEquals("1.0.0", bom.deployments().all().get(0).version()),
        () -> assertEquals(LocalDateTime.parse("2022-12-28T08:29:10.079226"),
            bom.deployments().all().get(0).timestamp())
    );
  }
}
