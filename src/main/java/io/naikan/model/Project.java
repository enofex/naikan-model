package io.naikan.model;

public record Project(String name, String groupId, String artifactId, String version, String description) {

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String name;
        private String groupId;
        private String artifactId;
        private String version;
        private String description;

        private Builder() {
        }

        public Builder name(String name) {
            this.name = name;
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

        public Project build() {
            return new Project(this.name, this.groupId, this.artifactId, this.version, this.description);
        }
    }
}
