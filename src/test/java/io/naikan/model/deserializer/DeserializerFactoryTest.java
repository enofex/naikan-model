package io.naikan.model.deserializer;


import io.naikan.model.deserializer.Deserializer;
import io.naikan.model.deserializer.DeserializerFactory;
import io.naikan.model.deserializer.json.DefaultJsonDeserializer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class DeserializerFactoryTest {

  @Test
  void shouldReturnJsonDeserializer() {
    Deserializer deserializer = DeserializerFactory.newJsonDeserializer();

    assertTrue(deserializer instanceof DefaultJsonDeserializer);
  }
}