package io.naikan.model.module;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import io.naikan.model.License;
import io.naikan.model.Licenses;

import java.io.IOException;
import java.util.List;

final class LicensesDeserializer extends AbstractDeserializer<Licenses> {

    static final LicensesDeserializer INSTANCE = new LicensesDeserializer();

    LicensesDeserializer() {
        super(Licenses.class, Licenses.empty());
    }

    @Override
    public Licenses deserialize(JsonParser jsonParser, DeserializationContext ctx) throws IOException {
        License[] licenses = jsonParser.readValueAs(License[].class);

        return new Licenses(List.of(licenses));
    }
}
