package com.enofex.naikan.model.module;

import com.enofex.naikan.model.Deployment;
import com.enofex.naikan.model.Deployments;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import java.io.IOException;
import java.io.Serial;
import java.util.List;

final class DeploymentsDeserializer extends AbstractDeserializer<Deployments> {

  @Serial
  private static final long serialVersionUID = 1L;

  static final DeploymentsDeserializer INSTANCE = new DeploymentsDeserializer();

  DeploymentsDeserializer() {
    super(Deployments.class, Deployments.empty());
  }

  @Override
  public Deployments deserialize(JsonParser jsonParser, DeserializationContext ctx)
      throws IOException {
    Deployment[] deployments = jsonParser.readValueAs(Deployment[].class);

    return new Deployments(List.of(deployments));
  }

}
