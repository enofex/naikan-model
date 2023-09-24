package com.enofex.naikan.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import org.junit.jupiter.api.Test;

class IntegrationTest {

  @Test
  void shouldCreateIntegrationObject() {
    Integration integration = Integration.builder()
        .name("TestName")
        .url("https://example.com")
        .description("TestDescription")
        .tags(new Tags(List.of("tag1", "tag2")))
        .build();

    assertNotNull(integration);
  }

  @Test
  void shouldVerifyIntegrationFields() {
    Integration integration = Integration.builder()
        .name("TestName")
        .url("https://example.com")
        .description("TestDescription")
        .tags(new Tags(List.of("tag1", "tag2")))
        .build();

    assertAll("Integration fields",
        () -> assertEquals("TestName", integration.name()),
        () -> assertEquals("https://example.com", integration.url()),
        () -> assertEquals("TestDescription", integration.description()),
        () -> assertEquals(new Tags(List.of("tag1", "tag2")), integration.tags())
    );
  }
}
