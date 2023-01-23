package io.naikan.model.module;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import io.naikan.model.Integration;
import io.naikan.model.Integrations;

import java.io.IOException;
import java.util.List;

final class IntegrationsDeserializer extends AbstractDeserializer<Integrations> {

    static final IntegrationsDeserializer INSTANCE = new IntegrationsDeserializer();

    IntegrationsDeserializer() {
        super(Integrations.class, Integrations.empty());
    }

    @Override
    public Integrations deserialize(JsonParser jsonParser, DeserializationContext ctx) throws IOException {
        Integration[] integrations = jsonParser.readValueAs(Integration[].class);

        return new Integrations(List.of(integrations));
    }
}
