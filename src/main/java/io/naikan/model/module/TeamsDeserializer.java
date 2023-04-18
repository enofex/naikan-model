package io.naikan.model.module;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import io.naikan.model.Team;
import io.naikan.model.Teams;

import java.io.IOException;
import java.io.Serial;
import java.util.List;

final class TeamsDeserializer extends AbstractDeserializer<Teams> {

  @Serial
  private static final long serialVersionUID = 1L;

  static final TeamsDeserializer INSTANCE = new TeamsDeserializer();

  TeamsDeserializer() {
    super(Teams.class, Teams.empty());
  }

  @Override
  public Teams deserialize(JsonParser jsonParser, DeserializationContext ctx) throws IOException {
    Team[] teams = jsonParser.readValueAs(Team[].class);

    return new Teams(List.of(teams));
  }
}