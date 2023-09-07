package com.enofex.naikan.model;

import java.time.LocalDateTime;

public record RepositoryTag(String name, LocalDateTime timestamp) {

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {

    private String name;
    private LocalDateTime timestamp;

    private Builder() {
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder timestamp(LocalDateTime timestamp) {
      this.timestamp = timestamp;
      return this;
    }

    public RepositoryTag build() {
      return new RepositoryTag(this.name, this.timestamp);
    }
  }
}
