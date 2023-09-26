package com.enofex.naikan.model.module;

import com.enofex.naikan.model.Branch;
import com.enofex.naikan.model.Branches;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import java.io.IOException;
import java.io.Serial;
import java.util.List;

final class BranchesDeserializer extends AbstractDeserializer<Branches> {

  @Serial
  private static final long serialVersionUID = 1L;

  static final BranchesDeserializer INSTANCE = new BranchesDeserializer();

  BranchesDeserializer() {
    super(Branches.class, Branches.empty());
  }

  @Override
  public Branches deserialize(JsonParser jsonParser, DeserializationContext ctx)
      throws IOException {
    Branch[] branches = jsonParser.readValueAs(Branch[].class);

    return new Branches(List.of(branches));
  }
}
