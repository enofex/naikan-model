package com.enofex.naikan.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import org.junit.jupiter.api.Test;

class DeveloperTest {

  @Test
  void shouldCreateDeveloperObject() {
    Developer developer = Developer.builder()
        .name("TestName")
        .username("TestUsername")
        .title("TestTitle")
        .department("TestDepartment")
        .email("test@example.com")
        .phone("123-456-7890")
        .organization("TestOrg")
        .organizationUrl("https://example.com")
        .timezone("UTC")
        .description("TestDescription")
        .roles(new Roles(List.of("Role1", "Role2")))
        .build();

    assertNotNull(developer);
  }

  @Test
  void shouldVerifyDeveloperFields() {
    Developer developer = Developer.builder()
        .name("TestName")
        .username("TestUsername")
        .title("TestTitle")
        .department("TestDepartment")
        .email("test@example.com")
        .phone("123-456-7890")
        .organization("TestOrg")
        .organizationUrl("https://example.com")
        .timezone("UTC")
        .description("TestDescription")
        .roles(new Roles(List.of("Role1", "Role2")))
        .build();

    assertAll("Developer fields",
        () -> assertEquals("TestName", developer.name()),
        () -> assertEquals("TestUsername", developer.username()),
        () -> assertEquals("TestTitle", developer.title()),
        () -> assertEquals("TestDepartment", developer.department()),
        () -> assertEquals("test@example.com", developer.email()),
        () -> assertEquals("123-456-7890", developer.phone()),
        () -> assertEquals("TestOrg", developer.organization()),
        () -> assertEquals("https://example.com", developer.organizationUrl()),
        () -> assertEquals("UTC", developer.timezone()),
        () -> assertEquals("TestDescription", developer.description()),
        () -> assertEquals(new Roles(List.of("Role1", "Role2")), developer.roles())
    );
  }
}
