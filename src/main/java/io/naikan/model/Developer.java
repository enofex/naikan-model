package io.naikan.model;

public record Developer(String name, String title, String department, String email, String phone, String organization,
                        String organizationUrl, String timezone, String description, Roles roles) {

    public Developer {
        roles = roles != null ? roles : Roles.empty();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String name;
        private String department;
        private String title;
        private String email;
        private String phone;
        private String organization;
        private String organizationUrl;
        private String timezone;
        private String description;
        private Roles roles;

        private Builder() {
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder department(String department) {
            this.department = department;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder organization(String organization) {
            this.organization = organization;
            return this;
        }

        public Builder organizationUrl(String organizationUrl) {
            this.organizationUrl = organizationUrl;
            return this;
        }

        public Builder timezone(String timezone) {
            this.timezone = timezone;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder roles(Roles roles) {
            this.roles = roles;
            return this;
        }

        public Developer build() {
            return new Developer(this.name, this.title, this.department, this.email, this.phone, this.organization, this.organizationUrl, this.timezone, this.description, this.roles);
        }
    }
}
