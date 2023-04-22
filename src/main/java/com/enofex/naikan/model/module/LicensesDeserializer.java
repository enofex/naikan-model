package com.enofex.naikan.model.module;

import com.enofex.naikan.model.License;
import com.enofex.naikan.model.Licenses;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import java.io.IOException;
import java.io.Serial;
import java.util.List;

final class LicensesDeserializer extends AbstractDeserializer<Licenses> {

  @Serial
  private static final long serialVersionUID = 1L;

  static final LicensesDeserializer INSTANCE = new LicensesDeserializer();

  LicensesDeserializer() {
    super(Licenses.class, Licenses.empty());
  }

  @Override
  public Licenses deserialize(JsonParser jsonParser, DeserializationContext ctx)
      throws IOException {
    License[] licenses = jsonParser.readValueAs(License[].class);

    return new Licenses(List.of(licenses));
  }
}
