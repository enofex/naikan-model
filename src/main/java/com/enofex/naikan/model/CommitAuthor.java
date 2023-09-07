package com.enofex.naikan.model;

public record CommitAuthor(String name, String email) {

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {

    private String name;
    private String email;

    private Builder() {
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder email(String email) {
      this.email = email;
      return this;
    }

    public CommitAuthor build() {
      return new CommitAuthor(this.name, this.email);
    }
  }
}
