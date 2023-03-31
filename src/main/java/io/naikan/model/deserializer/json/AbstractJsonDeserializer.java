package io.naikan.model.deserializer.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.naikan.model.module.ObjectMapperFactory;

abstract class AbstractJsonDeserializer implements JsonDeserializer {

    private final ObjectMapper mapper;

    AbstractJsonDeserializer() {
        this.mapper = ObjectMapperFactory.newObjectMapper();
    }

    ObjectMapper mapper() {
        return this.mapper;
    }
}
