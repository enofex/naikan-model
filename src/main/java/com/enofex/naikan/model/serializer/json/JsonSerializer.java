package com.enofex.naikan.model.serializer.json;

import com.enofex.naikan.model.Bom;
import com.enofex.naikan.model.serializer.Serializer;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.File;

public interface JsonSerializer extends Serializer {


  File toFile(Bom bom, String fileName, boolean prettyPrint);

  JsonNode toJsonNode(Bom bom);

  String toJsonString(Bom bom);

  @Override
  default boolean supports(String type) {
    return "json".equalsIgnoreCase(type);
  }
}