package io.naikan.model;

public record Technology(String name, String version, String description, Tags tags) {

    public Technology {
        tags = tags != null ? tags : Tags.empty();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String name;
        private String version;
        private String description;
        private Tags tags;

        private Builder() {
        }

        public Builder name(String name) {
            this.name = name;
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

        public Builder tags(Tags tags) {
            this.tags = tags;
            return this;
        }

        public Technology build() {
            return new Technology(this.name, this.version, this.description, this.tags);
        }
    }
}
