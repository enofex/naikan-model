package io.naikan.model.serializer;

import io.naikan.model.Bom;
import io.naikan.model.BomSchema;
import java.io.File;

public interface Serializer {

  BomSchema.Version getSchemaVersion();

  File toFile(Bom bom, String fileName);

  String toString(Bom bom);

  boolean supports(String type);
}
