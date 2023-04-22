package com.enofex.naikan.model.serializer;


import static org.junit.jupiter.api.Assertions.assertTrue;

import com.enofex.naikan.model.BomSchema;
import com.enofex.naikan.model.serializer.json.JsonSerializer;
import org.junit.jupiter.api.Test;

class SerializerFactoryTest {

  @Test
  void shouldReturnJsonSerializer() {
    Serializer serializer = SerializerFactory.newJsonSerializer(BomSchema.Version.VERSION_10);

    assertTrue(serializer instanceof JsonSerializer);
  }
}