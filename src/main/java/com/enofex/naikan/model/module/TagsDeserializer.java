package com.enofex.naikan.model.module;

import com.enofex.naikan.model.Tags;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import java.io.IOException;
import java.io.Serial;
import java.util.List;

final class TagsDeserializer extends AbstractDeserializer<Tags> {

  @Serial
  private static final long serialVersionUID = 1L;

  static final TagsDeserializer INSTANCE = new TagsDeserializer();

  TagsDeserializer() {
    super(Tags.class, Tags.empty());
  }

  @Override
  public Tags deserialize(JsonParser jsonParser, DeserializationContext ctx) throws IOException {
    String[] teams = jsonParser.readValueAs(String[].class);

    return new Tags(List.of(teams));
  }
}
