package io.naikan.model.module;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import io.naikan.model.AbstractContainer;

import java.io.IOException;

class AbstractContainerSerializer extends StdSerializer<AbstractContainer> {

    static final AbstractContainerSerializer INSTANCE = new AbstractContainerSerializer();

    protected AbstractContainerSerializer() {
        super(AbstractContainer.class);
    }

    @Override
    public void serialize(AbstractContainer value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        if (value == null) {
            return;
        }

        gen.writeStartArray();

        for (Object object : value.all()) {
            gen.writeObject(object);
        }

        gen.writeEndArray();
    }
}
