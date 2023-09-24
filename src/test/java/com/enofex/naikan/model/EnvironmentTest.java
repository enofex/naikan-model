package com.enofex.naikan.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import org.junit.jupiter.api.Test;

class EnvironmentTest {

  @Test
  void shouldCreateEnvironmentObject() {
    Environment environment = Environment.builder()
        .name("TestName")
        .location("TestLocation")
        .description("TestDescription")
        .tags(new Tags(List.of("tag1", "tag2")))
        .build();

    assertNotNull(environment);
  }

  @Test
  void shouldVerifyEnvironmentFields() {
    Environment environment = Environment.builder()
        .name("TestName")
        .location("TestLocation")
        .description("TestDescription")
        .tags(new Tags(List.of("tag1", "tag2")))
        .build();

    assertAll("Environment fields",
        () -> assertEquals("TestName", environment.name()),
        () -> assertEquals("TestLocation", environment.location()),
        () -> assertEquals("TestDescription", environment.description()),
        () -> assertEquals(new Tags(List.of("tag1", "tag2")), environment.tags())
    );
  }
}
