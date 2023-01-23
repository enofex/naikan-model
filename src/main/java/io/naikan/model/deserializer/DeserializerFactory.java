package io.naikan.model.deserializer;

import io.naikan.model.deserializer.json.JsonDeserializer;

public final class DeserializerFactory {

    private DeserializerFactory() {
    }

    public static Deserializer newJsonDeserializer() {
        return new JsonDeserializer();
    }
}