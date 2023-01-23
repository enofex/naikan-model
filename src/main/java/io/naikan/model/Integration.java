package io.naikan.model;

public record Integration(String name, String url, String description, Tags tags) {

    public Integration {
        tags = tags != null ? tags : Tags.empty();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {

        private String name;
        private String url;
        private String description;
        private Tags tags;

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

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder tags(Tags tags) {
            this.tags = tags;
            return this;
        }

        public Integration build() {
            return new Integration(this.name, this.url, this.description, this.tags);
        }
    }
}
