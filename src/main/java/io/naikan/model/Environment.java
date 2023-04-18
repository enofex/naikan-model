package io.naikan.model;

public record Environment(String name, String location, String description, Tags tags) {

  public Environment {
    tags = tags != null ? tags : Tags.empty();
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {

    private String name;
    private String location;
    private String description;
    private Tags tags;

    private Builder() {
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder location(String location) {
      this.location = location;
      return this;
    }

    public Builder description(String description) {
      this.description = description;
      return this;
    }

    public Builder tags(Tags tags) {
      this.tags = tags;
      return this;
    }

    public Environment build() {
      return new Environment(this.name, this.location, this.description, this.tags);
    }
  }
}
