package com.enofex.naikan.model.serializer;

import com.enofex.naikan.model.Bom;
import com.enofex.naikan.model.BomSchema;
import java.io.File;

public interface Serializer {

  BomSchema.Version getSchemaVersion();

  File toFile(Bom bom, String fileName);

  String toString(Bom bom);

  boolean supports(String type);
}
