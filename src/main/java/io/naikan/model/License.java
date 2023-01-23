package io.naikan.model;

public record License(String name, String url, String description) {

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String name;

        private String url;
        private String description;

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

        public License build() {
            return new License(this.name, this.url, this.description);
        }
    }
}
