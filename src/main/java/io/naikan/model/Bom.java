package io.naikan.model;

import java.time.LocalDateTime;

public record Bom(String id, String bomFormat, String specVersion, LocalDateTime timestamp, Project project,
                  Organization organization, Teams teams, Developers developers, Contacts contacts,
                  Technologies technologies, Licenses licenses, Documentations documentations,
                  Integrations integrations, Tags tags, Deployments deployments) {

    public static final String BOM_FORMAT = "Naikan";

    public Bom {
        bomFormat = bomFormat != null ? bomFormat : BOM_FORMAT;
        specVersion = specVersion != null ? specVersion : BomSchema.VERSION_LATEST.version();
        teams = teams != null ? teams : Teams.empty();
        developers = developers != null ? developers : Developers.empty();
        contacts = contacts != null ? contacts : Contacts.empty();
        technologies = technologies != null ? technologies : Technologies.empty();
        licenses = licenses != null ? licenses : Licenses.empty();
        documentations = documentations != null ? documentations : Documentations.empty();
        integrations = integrations != null ? integrations : Integrations.empty();
        tags = tags != null ? tags : Tags.empty();
        deployments = deployments != null ? deployments : Deployments.empty();
    }

    public static Builder builder() {
        return new Builder();
    }

    public Builder toBuilder() {
        return new Builder(this);
    }

    public static final class Builder {

        private String id;
        private String bomFormat;
        private String specVersion;
        private LocalDateTime timestamp;
        private Project project;
        private Organization organization;
        private Teams teams;
        private Developers developers;
        private Contacts contacts;
        private Technologies technologies;
        private Licenses licenses;
        private Documentations documentations;
        private Integrations integrations;
        private Tags tags;
        private Deployments deployments;

        private Builder() {
        }

        private Builder(Bom bom) {
            this.id = bom.id();
            this.bomFormat = bom.bomFormat();
            this.specVersion = bom.specVersion();
            this.timestamp = bom.timestamp();
            this.project = bom.project();
            this.organization = bom.organization();
            this.teams = bom.teams();
            this.developers = bom.developers();
            this.contacts = bom.contacts();
            this.technologies = bom.technologies();
            this.licenses = bom.licenses();
            this.documentations = bom.documentations();
            this.integrations = bom.integrations();
            this.tags = bom.tags();
            this.deployments = bom.deployments();
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder bomFormat(String bomFormat) {
            this.bomFormat = bomFormat;
            return this;
        }

        public Builder specVersion(String specVersion) {
            this.specVersion = specVersion;
            return this;
        }

        public Builder timestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder project(Project project) {
            this.project = project;
            return this;
        }

        public Builder organization(Organization organization) {
            this.organization = organization;
            return this;
        }

        public Builder teams(Teams teams) {
            this.teams = teams;
            return this;
        }

        public Builder developers(Developers developers) {
            this.developers = developers;
            return this;
        }

        public Builder contacts(Contacts contacts) {
            this.contacts = contacts;
            return this;
        }

        public Builder technologies(Technologies technologies) {
            this.technologies = technologies;
            return this;
        }

        public Builder licenses(Licenses licenses) {
            this.licenses = licenses;
            return this;
        }

        public Builder documentations(Documentations documentations) {
            this.documentations = documentations;
            return this;
        }

        public Builder integrations(Integrations integrations) {
            this.integrations = integrations;
            return this;
        }

        public Builder tags(Tags tags) {
            this.tags = tags;
            return this;
        }

        public Builder deployments(Deployments deployments) {
            this.deployments = deployments;
            return this;
        }

        public Bom build() {
            return new Bom(this.id, this.bomFormat, this.specVersion, this.timestamp, this.project, this.organization, this.teams,
                    this.developers, this.contacts, this.technologies, this.licenses, this.documentations, this.integrations, this.tags,
                    this.deployments);
        }
    }

}
