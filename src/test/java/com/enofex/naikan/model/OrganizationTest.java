package com.enofex.naikan.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class OrganizationTest {

  @Test
  void shouldCreateOrganizationObject() {
    Organization organization = Organization.builder()
        .name("TestName")
        .url("https://example.com")
        .department("TestDepartment")
        .description("TestDescription")
        .build();

    assertNotNull(organization);
  }

  @Test
  void shouldVerifyOrganizationFields() {
    Organization organization = Organization.builder()
        .name("TestName")
        .url("https://example.com")
        .department("TestDepartment")
        .description("TestDescription")
        .build();

    assertAll("Organization fields",
        () -> assertEquals("TestName", organization.name()),
        () -> assertEquals("https://example.com", organization.url()),
        () -> assertEquals("TestDepartment", organization.department()),
        () -> assertEquals("TestDescription", organization.description())
    );
  }
}
