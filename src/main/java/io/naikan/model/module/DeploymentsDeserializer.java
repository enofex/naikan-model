package io.naikan.model.module;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import io.naikan.model.Deployment;
import io.naikan.model.Deployments;

import java.io.IOException;
import java.util.List;

final class DeploymentsDeserializer extends AbstractDeserializer<Deployments> {

    static final DeploymentsDeserializer INSTANCE = new DeploymentsDeserializer();

    DeploymentsDeserializer() {
        super(Deployments.class, Deployments.empty());
    }

    @Override
    public Deployments deserialize(JsonParser jsonParser, DeserializationContext ctx) throws IOException {
        Deployment[] deployments = jsonParser.readValueAs(Deployment[].class);

        return new Deployments(List.of(deployments));
    }

}
