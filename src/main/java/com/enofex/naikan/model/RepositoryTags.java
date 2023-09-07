package com.enofex.naikan.model;

import java.util.List;

public final class RepositoryTags extends AbstractContainer<RepositoryTag> {

  private static final RepositoryTags NO_REPOSITORY_TAGS = new RepositoryTags(List.of());

  public RepositoryTags(List<RepositoryTag> repositoryTags) {
    super(repositoryTags);
  }

  public static RepositoryTags empty() {
    return NO_REPOSITORY_TAGS;
  }

  public static RepositoryTags of(RepositoryTag... tags) {
    return new RepositoryTags(List.of(tags));
  }
}
