package com.enofex.naikan.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import org.junit.jupiter.api.Test;

class ContactTest {

  @Test
  void shouldCreateContactObject() {
    Contact contact = Contact.builder()
        .name("TestName")
        .title("TestTitle")
        .email("test@example.com")
        .phone("123-456-7890")
        .description("TestDescription")
        .roles(new Roles(List.of("Role1", "Role2")))
        .build();

    assertNotNull(contact);
  }

  @Test
  void shouldVerifyContactFields() {
    Contact contact = Contact.builder()
        .name("TestName")
        .title("TestTitle")
        .email("test@example.com")
        .phone("123-456-7890")
        .description("TestDescription")
        .roles(new Roles(List.of("Role1", "Role2")))
        .build();

    assertAll("Contact fields",
        () -> assertEquals("TestName", contact.name()),
        () -> assertEquals("TestTitle", contact.title()),
        () -> assertEquals("test@example.com", contact.email()),
        () -> assertEquals("123-456-7890", contact.phone()),
        () -> assertEquals("TestDescription", contact.description()),
        () -> assertEquals(new Roles(List.of("Role1", "Role2")), contact.roles())
    );
  }
}
