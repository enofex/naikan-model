package com.enofex.naikan.model;

import java.time.LocalDateTime;

public record Deployment(String environment, String location, String version,
                         LocalDateTime timestamp) {

  public Deployment {
    timestamp = timestamp != null ? timestamp : LocalDateTime.now();
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {

    private String environment;
    private String location;
    private String version;
    private LocalDateTime timestamp;

    private Builder() {
    }

    public Builder environment(String environment) {
      this.environment = environment;
      return this;
    }

    public Builder location(String location) {
      this.location = location;
      return this;
    }

    public Builder version(String version) {
      this.version = version;
      return this;
    }

    public Builder timestamp(LocalDateTime timestamp) {
      this.timestamp = timestamp;
      return this;
    }

    public Deployment build() {
      return new Deployment(this.environment, this.location, this.version, this.timestamp);
    }
  }
}
