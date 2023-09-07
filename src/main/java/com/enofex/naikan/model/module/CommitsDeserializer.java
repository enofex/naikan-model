package com.enofex.naikan.model.module;

import com.enofex.naikan.model.Commit;
import com.enofex.naikan.model.Commits;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import java.io.IOException;
import java.io.Serial;
import java.util.List;

final class CommitsDeserializer extends AbstractDeserializer<Commits> {

  @Serial
  private static final long serialVersionUID = 1L;

  static final CommitsDeserializer INSTANCE = new CommitsDeserializer();

  CommitsDeserializer() {
    super(Commits.class, Commits.empty());
  }

  @Override
  public Commits deserialize(JsonParser jsonParser, DeserializationContext ctx)
      throws IOException {
    Commit[] commits = jsonParser.readValueAs(Commit[].class);

    return new Commits(List.of(commits));
  }
}
