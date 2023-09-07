package com.enofex.naikan.model;

import java.time.LocalDateTime;

public record Commit(String id, LocalDateTime timestamp, String shortMessage, CommitAuthor author,
                     CommitChanges changes) {

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {

    private String id;
    private LocalDateTime timestamp;
    private String shortMessage;
    private CommitAuthor author;
    private CommitChanges changes;

    private Builder() {
    }

    public Builder id(String id) {
      this.id = id;
      return this;
    }

    public Builder timestamp(LocalDateTime timestamp) {
      this.timestamp = timestamp;
      return this;
    }

    public Builder shortMessage(String shortMessage) {
      this.shortMessage = shortMessage;
      return this;
    }

    public Builder author(CommitAuthor author) {
      this.author = author;
      return this;
    }

    public Builder changes(CommitChanges changes) {
      this.changes = changes;
      return this;
    }

    public Commit build() {
      return new Commit(this.id, this.timestamp, this.shortMessage, this.author, this.changes);
    }
  }
}