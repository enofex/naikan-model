package com.enofex.naikan.model.deserializer.json;

import com.enofex.naikan.model.module.ObjectMapperFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

abstract class AbstractJsonDeserializer implements JsonDeserializer {

  private final ObjectMapper mapper;

  AbstractJsonDeserializer() {
    this.mapper = ObjectMapperFactory.newObjectMapper();
  }

  ObjectMapper mapper() {
    return this.mapper;
  }
}
