package com.enofex.naikan.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import org.junit.jupiter.api.Test;

class DocumentationTest {

  @Test
  void shouldCreateDocumentationObject() {
    Documentation documentation = Documentation.builder()
        .name("TestName")
        .location("TestLocation")
        .description("TestDescription")
        .tags(new Tags(List.of("tag1", "tag2")))
        .build();

    assertNotNull(documentation);
  }

  @Test
  void shouldVerifyDocumentationFields() {
    Documentation documentation = Documentation.builder()
        .name("TestName")
        .location("TestLocation")
        .description("TestDescription")
        .tags(new Tags(List.of("tag1", "tag2")))
        .build();

    assertAll("Documentation fields",
        () -> assertEquals("TestName", documentation.name()),
        () -> assertEquals("TestLocation", documentation.location()),
        () -> assertEquals("TestDescription", documentation.description()),
        () -> assertEquals(new Tags(List.of("tag1", "tag2")), documentation.tags())
    );
  }
}
