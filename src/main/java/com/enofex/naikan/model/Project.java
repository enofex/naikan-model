package com.enofex.naikan.model;

public record Project(String name, String inceptionYear, String url, String repository,
                      String packaging, String groupId, String artifactId, String version,
                      String description, String notes) {

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {

    private String name;
    private String inceptionYear;
    private String url;
    private String repository;
    private String packaging;
    private String groupId;
    private String artifactId;
    private String version;
    private String description;
    private String notes;

    private Builder() {
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder inceptionYear(String inceptionYear) {
      this.inceptionYear = inceptionYear;
      return this;
    }

    public Builder url(String url) {
      this.url = url;
      return this;
    }

    public Builder repository(String repository) {
      this.repository = repository;
      return this;
    }

    public Builder packaging(String packaging) {
      this.packaging = packaging;
      return this;
    }

    public Builder groupId(String groupId) {
      this.groupId = groupId;
      return this;
    }

    public Builder artifactId(String artifactId) {
      this.artifactId = artifactId;
      return this;
    }

    public Builder version(String version) {
      this.version = version;
      return this;
    }

    public Builder description(String description) {
      this.description = description;
      return this;
    }

    public Builder notes(String notes) {
      this.notes = notes;
      return this;
    }

    public Project build() {
      return new Project(this.name, this.inceptionYear, this.url, this.repository, this.packaging,
          this.groupId, this.artifactId, this.version, this.description, this.notes);
    }
  }
}
