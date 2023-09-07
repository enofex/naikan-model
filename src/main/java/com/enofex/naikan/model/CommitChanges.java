package com.enofex.naikan.model;

public record CommitChanges(CommitLinesChanges lines, CommitFilesChanges files) {

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {

    private CommitLinesChanges lines;
    private CommitFilesChanges files;

    private Builder() {
      this.lines = new CommitLinesChanges(0, 0);
      this.files = new CommitFilesChanges(0, 0, 0);
    }

    public Builder lines(int added, int deleted) {
      this.lines = new CommitLinesChanges(added, deleted);
      return this;
    }

    public Builder files(int added, int deleted, int changed) {
      this.files = new CommitFilesChanges(added, deleted, changed);
      return this;
    }

    public CommitChanges build() {
      return new CommitChanges(this.lines, this.files);
    }
  }

}