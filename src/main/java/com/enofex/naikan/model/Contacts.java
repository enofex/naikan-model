package com.enofex.naikan.model;

import java.util.List;

public final class Contacts extends AbstractContainer<Contact> {

  private static final Contacts NO_CONTACTS = new Contacts(List.of());

  public Contacts(List<Contact> contacts) {
    super(contacts);
  }

  public static Contacts empty() {
    return NO_CONTACTS;
  }
}
