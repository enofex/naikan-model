package com.enofex.naikan.model.module;

import com.enofex.naikan.model.RepositoryTag;
import com.enofex.naikan.model.RepositoryTags;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import java.io.IOException;
import java.io.Serial;
import java.util.List;

final class RepositoryTagsDeserializer extends AbstractDeserializer<RepositoryTags> {

  @Serial
  private static final long serialVersionUID = 1L;

  static final RepositoryTagsDeserializer INSTANCE = new RepositoryTagsDeserializer();

  RepositoryTagsDeserializer() {
    super(RepositoryTags.class, RepositoryTags.empty());
  }

  @Override
  public RepositoryTags deserialize(JsonParser jsonParser, DeserializationContext ctx)
      throws IOException {
    RepositoryTag[] tags = jsonParser.readValueAs(RepositoryTag[].class);

    return new RepositoryTags(List.of(tags));
  }
}
