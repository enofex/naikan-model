package com.enofex.naikan.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

class DeploymentTest {

  @Test
  void shouldCreateDeploymentObject() {
    Deployment deployment = Deployment.builder()
        .environment("TestEnvironment")
        .location("TestLocation")
        .version("1.0")
        .timestamp(LocalDateTime.of(2023, 9, 24, 12, 0))
        .build();

    assertNotNull(deployment);
  }

  @Test
  void shouldVerifyDeploymentFields() {
    Deployment deployment = Deployment.builder()
        .environment("TestEnvironment")
        .location("TestLocation")
        .version("1.0")
        .timestamp(LocalDateTime.of(2023, 9, 24, 12, 0))
        .build();

    assertAll("Deployment fields",
        () -> assertEquals("TestEnvironment", deployment.environment()),
        () -> assertEquals("TestLocation", deployment.location()),
        () -> assertEquals("1.0", deployment.version()),
        () -> assertEquals(LocalDateTime.of(2023, 9, 24, 12, 0), deployment.timestamp())
    );
  }
}
