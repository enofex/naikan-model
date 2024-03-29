package com.enofex.naikan.model;

import java.util.List;

public final class Tags extends AbstractContainer<String> {

  private static final Tags NO_TAGS = new Tags(List.of());

  public Tags(List<String> tags) {
    super(tags);
  }

  public static Tags empty() {
    return NO_TAGS;
  }

  public static Tags of(String... tags) {
    return new Tags(List.of(tags));
  }
}
