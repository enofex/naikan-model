package com.enofex.naikan.model.module;

import com.enofex.naikan.model.AbstractContainer;
import com.enofex.naikan.model.Branches;
import com.enofex.naikan.model.Commits;
import com.enofex.naikan.model.Contacts;
import com.enofex.naikan.model.Deployments;
import com.enofex.naikan.model.Developers;
import com.enofex.naikan.model.Documentations;
import com.enofex.naikan.model.Environments;
import com.enofex.naikan.model.Integrations;
import com.enofex.naikan.model.Licenses;
import com.enofex.naikan.model.RepositoryTags;
import com.enofex.naikan.model.Roles;
import com.enofex.naikan.model.Tags;
import com.enofex.naikan.model.Teams;
import com.enofex.naikan.model.Technologies;
import com.fasterxml.jackson.databind.module.SimpleModule;
import java.io.Serial;

public final class NaikanModule extends SimpleModule {

  @Serial
  private static final long serialVersionUID = 1L;

  public NaikanModule() {
    addDeserializer(Environments.class, EnvironmentsDeserializer.INSTANCE);
    addDeserializer(Contacts.class, ContactsDeserializer.INSTANCE);
    addDeserializer(Deployments.class, DeploymentsDeserializer.INSTANCE);
    addDeserializer(Documentations.class, DocumentationsDeserializer.INSTANCE);
    addDeserializer(Licenses.class, LicensesDeserializer.INSTANCE);
    addDeserializer(Integrations.class, IntegrationsDeserializer.INSTANCE);
    addDeserializer(Tags.class, TagsDeserializer.INSTANCE);
    addDeserializer(Teams.class, TeamsDeserializer.INSTANCE);
    addDeserializer(Technologies.class, TechnologiesDeserializer.INSTANCE);
    addDeserializer(Developers.class, DevelopersDeserializer.INSTANCE);
    addDeserializer(Roles.class, RolesDeserializer.INSTANCE);
    addDeserializer(Branches.class, BranchesDeserializer.INSTANCE);
    addDeserializer(RepositoryTags.class, RepositoryTagsDeserializer.INSTANCE);
    addDeserializer(Commits.class, CommitsDeserializer.INSTANCE);

    addSerializer(AbstractContainer.class, AbstractContainerSerializer.INSTANCE);
  }
}
