package io.naikan.model.module;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import io.naikan.model.Technologies;
import io.naikan.model.Technology;

import java.io.IOException;
import java.io.Serial;
import java.util.List;

final class TechnologiesDeserializer extends AbstractDeserializer<Technologies> {

  @Serial
  private static final long serialVersionUID = 1L;

  static final TechnologiesDeserializer INSTANCE = new TechnologiesDeserializer();

  TechnologiesDeserializer() {
    super(Technologies.class, Technologies.empty());
  }

  @Override
  public Technologies deserialize(JsonParser jsonParser, DeserializationContext ctx)
      throws IOException {
    Technology[] technologies = jsonParser.readValueAs(Technology[].class);

    return new Technologies(List.of(technologies));
  }
}
