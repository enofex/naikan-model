package com.enofex.naikan.model;

public record CommitFilesChanges(int added, int deleted, int changed) {

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {

    private int added;
    private int deleted;
    private int changed;

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

    public Builder changed(int changed) {
      this.changed = changed;
      return this;
    }

    public CommitFilesChanges build() {
      return new CommitFilesChanges(this.added, this.deleted, this.changed);
    }
  }

}
