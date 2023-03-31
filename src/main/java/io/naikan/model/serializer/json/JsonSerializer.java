package io.naikan.model.serializer.json;

import com.fasterxml.jackson.databind.JsonNode;

import io.naikan.model.Bom;
import io.naikan.model.serializer.Serializer;

public interface JsonSerializer extends Serializer {

    JsonNode toJsonNode(Bom bom);

    String toJsonString(Bom bom);

    @Override
    default boolean supports(String type) {
        return "json".equalsIgnoreCase(type);
    }
}