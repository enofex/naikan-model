package com.enofex.naikan.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class LicenseTest {

  @Test
  void shouldCreateLicenseObject() {
    License license = License.builder()
        .name("TestName")
        .url("https://example.com")
        .description("TestDescription")
        .build();

    assertNotNull(license);
  }

  @Test
  void shouldVerifyLicenseFields() {
    License license = License.builder()
        .name("TestName")
        .url("https://example.com")
        .description("TestDescription")
        .build();

    assertAll("License fields",
        () -> assertEquals("TestName", license.name()),
        () -> assertEquals("https://example.com", license.url()),
        () -> assertEquals("TestDescription", license.description())
    );
  }
}
