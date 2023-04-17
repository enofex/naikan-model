package io.naikan.model.module;

import java.io.Serial;

import com.fasterxml.jackson.databind.module.SimpleModule;

import io.naikan.model.AbstractContainer;
import io.naikan.model.Contacts;
import io.naikan.model.Deployments;
import io.naikan.model.Developers;
import io.naikan.model.Documentations;
import io.naikan.model.Environments;
import io.naikan.model.Integrations;
import io.naikan.model.Licenses;
import io.naikan.model.Roles;
import io.naikan.model.Tags;
import io.naikan.model.Teams;
import io.naikan.model.Technologies;

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

        addSerializer(AbstractContainer.class, AbstractContainerSerializer.INSTANCE);
    }
}
