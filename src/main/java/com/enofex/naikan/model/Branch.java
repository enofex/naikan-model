package com.enofex.naikan.model;

public record Branch(String name) {

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {

    private String name;

    private Builder() {
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Branch build() {
      return new Branch(this.name);
    }
  }
}
