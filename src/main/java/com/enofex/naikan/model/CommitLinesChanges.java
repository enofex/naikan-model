package com.enofex.naikan.model;

public record CommitLinesChanges(int added, int deleted) {

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {

    private int added;
    private int deleted;

    private Builder() {
    }

    public Builder added(int added) {
      this.added = added;
      return this;
    }

    public Builder deleted(int deleted) {
      this.deleted = deleted;
      return this;
    }

    public CommitLinesChanges build() {
      return new CommitLinesChanges(this.added, this.deleted);
    }
  }
}
