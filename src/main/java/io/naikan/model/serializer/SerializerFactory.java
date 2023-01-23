package io.naikan.model.serializer;

import io.naikan.model.BomSchema;
import io.naikan.model.serializer.json.JsonSerializer;
import io.naikan.model.serializer.json.JsonSerializer10;

public final class SerializerFactory {

    private SerializerFactory() {
    }

    public static JsonSerializer newJsonSerializer() {
        return new JsonSerializer10();
    }

    public static JsonSerializer newJsonSerializer(BomSchema.Version version) {
        return new JsonSerializer10();
    }
}