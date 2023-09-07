package com.enofex.naikan.model;

public record Repository(String name, String url, Commit firstCommit, int totalCommits,
                         String defaultBranch, Branches branches, RepositoryTags tags,
                         Commits commits) {

  public Repository {
    branches = branches != null ? branches : Branches.empty();
    tags = tags != null ? tags : RepositoryTags.empty();
    commits = commits != null ? commits : Commits.empty();
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {

    private String name;
    private String url;
    private Commit firstCommit;
    private int totalCommits;
    private String defaultBranch;
    private Branches branches;
    private RepositoryTags tags;
    private Commits commits;

    private Builder() {
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder url(String url) {
      this.url = url;
      return this;
    }

    public Builder firstCommit(Commit firstCommit) {
      this.firstCommit = firstCommit;
      return this;
    }

    public Builder totalCommits(int totalCommits) {
      this.totalCommits = totalCommits;
      return this;
    }

    public Builder defaultBranch(String defaultBranch) {
      this.defaultBranch = defaultBranch;
      return this;
    }

    public Builder branches(Branches branches) {
      this.branches = branches;
      return this;
    }

    public Builder tags(RepositoryTags tags) {
      this.tags = tags;
      return this;
    }

    public Builder commits(Commits commits) {
      this.commits = commits;
      return this;
    }

    public Repository build() {
      return new Repository(this.name, this.url, this.firstCommit, this.totalCommits,
          this.defaultBranch,
          this.branches, this.tags,
          this.commits);
    }
  }
}