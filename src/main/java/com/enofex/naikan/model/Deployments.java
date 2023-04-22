package com.enofex.naikan.model;

import java.util.List;

public final class Deployments extends AbstractContainer<Deployment> {

  private static final Deployments NO_DEPLOYMENTS = new Deployments(List.of());

  public Deployments(List<Deployment> deployments) {
    super(deployments);
  }

  public static Deployments empty() {
    return NO_DEPLOYMENTS;
  }
}
