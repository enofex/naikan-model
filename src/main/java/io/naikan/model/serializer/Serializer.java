package io.naikan.model.serializer;

import java.io.File;

import io.naikan.model.Bom;
import io.naikan.model.BomSchema;

public interface Serializer {

    BomSchema.Version getSchemaVersion();

    File toFile(Bom bom, String fileName);

    String toString(Bom bom);

    boolean supports(String type);
}
