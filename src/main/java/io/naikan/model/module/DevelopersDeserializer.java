package io.naikan.model.module;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import io.naikan.model.Developer;
import io.naikan.model.Developers;

import java.io.IOException;
import java.util.List;

final class DevelopersDeserializer extends AbstractDeserializer<Developers> {

    static final DevelopersDeserializer INSTANCE = new DevelopersDeserializer();

    DevelopersDeserializer() {
        super(Developers.class, Developers.empty());
    }

    @Override
    public Developers deserialize(JsonParser jsonParser, DeserializationContext ctx) throws IOException {
        Developer[] developers = jsonParser.readValueAs(Developer[].class);

        return new Developers(List.of(developers));
    }
}
