package com.enofex.naikan.model.deserializer.json;

import com.enofex.naikan.model.deserializer.Deserializer;

public interface JsonDeserializer extends Deserializer {

  @Override
  default boolean supports(String type) {
    return "json".equalsIgnoreCase(type);
  }
}
