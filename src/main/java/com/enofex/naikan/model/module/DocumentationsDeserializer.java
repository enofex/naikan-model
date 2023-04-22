package com.enofex.naikan.model.module;

import com.enofex.naikan.model.Documentation;
import com.enofex.naikan.model.Documentations;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import java.io.IOException;
import java.io.Serial;
import java.util.List;

final class DocumentationsDeserializer extends AbstractDeserializer<Documentations> {

  @Serial
  private static final long serialVersionUID = 1L;

  static final DocumentationsDeserializer INSTANCE = new DocumentationsDeserializer();

  DocumentationsDeserializer() {
    super(Documentations.class, Documentations.empty());
  }

  @Override
  public Documentations deserialize(JsonParser jsonParser, DeserializationContext ctx)
      throws IOException {
    Documentation[] documentations = jsonParser.readValueAs(Documentation[].class);

    return new Documentations(List.of(documentations));
  }
}
