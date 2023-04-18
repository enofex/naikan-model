package io.naikan.model.serializer;


import static org.junit.jupiter.api.Assertions.assertTrue;

import io.naikan.model.BomSchema;
import io.naikan.model.serializer.json.JsonSerializer;
import org.junit.jupiter.api.Test;

class SerializerFactoryTest {

  @Test
  void shouldReturnJsonSerializer() {
    Serializer serializer = SerializerFactory.newJsonSerializer(BomSchema.Version.VERSION_10);

    assertTrue(serializer instanceof JsonSerializer);
  }
}