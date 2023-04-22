package com.enofex.naikan.model.module;

import com.enofex.naikan.model.Environment;
import com.enofex.naikan.model.Environments;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import java.io.IOException;
import java.io.Serial;
import java.util.List;

final class EnvironmentsDeserializer extends AbstractDeserializer<Environments> {

  @Serial
  private static final long serialVersionUID = 1L;

  static final EnvironmentsDeserializer INSTANCE = new EnvironmentsDeserializer();

  EnvironmentsDeserializer() {
    super(Environments.class, Environments.empty());
  }

  @Override
  public Environments deserialize(JsonParser jsonParser, DeserializationContext ctx)
      throws IOException {
    Environment[] environments = jsonParser.readValueAs(Environment[].class);

    return new Environments(List.of(environments));
  }
}
