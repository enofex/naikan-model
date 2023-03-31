package io.naikan.model.module;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import io.naikan.model.Roles;

import java.io.IOException;
import java.io.Serial;
import java.util.List;

final class RolesDeserializer extends AbstractDeserializer<Roles> {

    @Serial
    private static final long serialVersionUID = 1L;

    static final RolesDeserializer INSTANCE = new RolesDeserializer();

    RolesDeserializer() {
        super(Roles.class, Roles.empty());
    }

    @Override
    public Roles deserialize(JsonParser jsonParser, DeserializationContext ctx) throws IOException {
        String[] roles = jsonParser.readValueAs(String[].class);

        return new Roles(List.of(roles));
    }
}
