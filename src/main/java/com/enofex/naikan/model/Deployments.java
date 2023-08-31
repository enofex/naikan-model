package com.enofex.naikan.model;

import java.util.Comparator;
import java.util.List;

public final class Deployments extends AbstractContainer<Deployment> {

  private static final Deployments NO_DEPLOYMENTS = new Deployments(List.of());

  public Deployments(List<Deployment> deployments) {
    super(deployments != null
        ? deployments.stream().sorted(Comparator.comparing(Deployment::timestamp)).toList()
        : List.of());
  }

  public static Deployments empty() {
    return NO_DEPLOYMENTS;
  }
}
