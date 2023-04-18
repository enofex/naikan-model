package io.naikan.model;

public record Organization(String name, String url, String department, String description) {

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {

    private String name;
    private String url;
    private String department;
    private String description;

    private Builder() {
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder department(String department) {
      this.department = department;
      return this;
    }

    public Builder url(String url) {
      this.url = url;
      return this;
    }

    public Builder description(String description) {
      this.description = description;
      return this;
    }

    public Organization build() {
      return new Organization(this.name, this.url, this.department, this.description);
    }
  }
}
