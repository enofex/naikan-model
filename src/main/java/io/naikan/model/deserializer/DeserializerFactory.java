package io.naikan.model.deserializer;

import java.util.ServiceLoader;

public final class DeserializerFactory {

    private DeserializerFactory() {
    }

    public static Deserializer newJsonDeserializer() {
        return loadJsonDeserializer();
    }

    private static Deserializer loadJsonDeserializer() {
        ServiceLoader<Deserializer> deserializers = ServiceLoader.load(Deserializer.class);

        for (Deserializer deserializer : deserializers) {
            if (deserializer.supports("json")) {
                return deserializer;
            }
        }

        return null;
    }
}