package io.naikan.model.serializer;

import io.naikan.model.BomSchema;
import java.util.ServiceLoader;

public final class SerializerFactory {

  private SerializerFactory() {
  }

  public static Serializer newJsonSerializer() {
    return loadJsonSerializer(BomSchema.VERSION_LATEST);
  }

  public static Serializer newJsonSerializer(BomSchema.Version version) {
    return loadJsonSerializer(version);
  }

  private static Serializer loadJsonSerializer(BomSchema.Version version) {
    ServiceLoader<Serializer> serializers = ServiceLoader.load(Serializer.class);

    for (Serializer serializer : serializers) {
      if (serializer.supports("json") && serializer.getSchemaVersion() == version) {
        return serializer;
      }
    }

    return null;
  }
}