package com.enofex.naikan.model.module;

import com.enofex.naikan.model.AbstractContainer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;
import java.io.Serial;

class AbstractContainerSerializer extends StdSerializer<AbstractContainer> {

  @Serial
  private static final long serialVersionUID = 1L;

  static final AbstractContainerSerializer INSTANCE = new AbstractContainerSerializer();

  protected AbstractContainerSerializer() {
    super(AbstractContainer.class);
  }

  @Override
  public void serialize(AbstractContainer value, JsonGenerator gen, SerializerProvider provider)
      throws IOException {
    if (value == null) {
      return;
    }

    gen.writeStartArray();

    for (Object object : value.all()) {
      gen.writeObject(object);
    }

    gen.writeEndArray();
  }
}
