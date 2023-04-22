package com.enofex.naikan.model.module;

import com.enofex.naikan.model.Developer;
import com.enofex.naikan.model.Developers;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import java.io.IOException;
import java.io.Serial;
import java.util.List;

final class DevelopersDeserializer extends AbstractDeserializer<Developers> {

  @Serial
  private static final long serialVersionUID = 1L;

  static final DevelopersDeserializer INSTANCE = new DevelopersDeserializer();

  DevelopersDeserializer() {
    super(Developers.class, Developers.empty());
  }

  @Override
  public Developers deserialize(JsonParser jsonParser, DeserializationContext ctx)
      throws IOException {
    Developer[] developers = jsonParser.readValueAs(Developer[].class);

    return new Developers(List.of(developers));
  }
}
