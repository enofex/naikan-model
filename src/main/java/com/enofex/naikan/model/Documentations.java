package com.enofex.naikan.model;

import java.util.List;

public final class Documentations extends AbstractContainer<Documentation> {

  private static final Documentations NO_DOCUMENTATIONS = new Documentations(List.of());

  public Documentations(List<Documentation> documentations) {
    super(documentations);
  }

  public static Documentations empty() {
    return NO_DOCUMENTATIONS;
  }

  public static Documentations of(Documentation... documentations) {
    return new Documentations(List.of(documentations));
  }
}
