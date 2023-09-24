package com.enofex.naikan.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import org.junit.jupiter.api.Test;

class TechnologyTest {

  private final Technology technology = Technology.builder()
      .name("TestName")
      .version("1.0")
      .description("TestDescription")
      .tags(new Tags(List.of("tag1", "tag2")))
      .build();

  @Test
  void shouldCreateTechnologyObject() {
    assertNotNull(this.technology);
  }

  @Test
  void shouldVerifyTechnologyFields() {
    assertAll("Technology fields",
        () -> assertEquals("TestName", this.technology.name()),
        () -> assertEquals("1.0", this.technology.version()),
        () -> assertEquals("TestDescription", this.technology.description()),
        () -> assertEquals(new Tags(List.of("tag1", "tag2")), this.technology.tags())
    );
  }

  @Test
  void shouldCreateTechnologyWithBuilder() {
    Technology.Builder builder = Technology.builder()
        .name("BuilderTestName")
        .version("2.0")
        .description("BuilderTestDescription")
        .tags(new Tags(List.of("tag3")));

    Technology builtTechnology = builder.build();

    assertAll("Technology fields",
        () -> assertEquals("BuilderTestName", builtTechnology.name()),
        () -> assertEquals("2.0", builtTechnology.version()),
        () -> assertEquals("BuilderTestDescription", builtTechnology.description()),
        () -> assertEquals(new Tags(List.of("tag3")), builtTechnology.tags())
    );
  }
}
