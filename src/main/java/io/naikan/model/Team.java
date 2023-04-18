package io.naikan.model;

public record Team(String name, String description) {

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {

    private String name;
    private String description;

    private Builder() {
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder description(String description) {
      this.description = description;
      return this;
    }

    public Team build() {
      return new Team(this.name, this.description);
    }
  }
}
