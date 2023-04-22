package com.enofex.naikan.model.deserializer;


import static org.junit.jupiter.api.Assertions.assertTrue;

import com.enofex.naikan.model.deserializer.json.DefaultJsonDeserializer;
import org.junit.jupiter.api.Test;

class DeserializerFactoryTest {

  @Test
  void shouldReturnJsonDeserializer() {
    Deserializer deserializer = DeserializerFactory.newJsonDeserializer();

    assertTrue(deserializer instanceof DefaultJsonDeserializer);
  }
}