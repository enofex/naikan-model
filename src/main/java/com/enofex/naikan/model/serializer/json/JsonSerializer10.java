package com.enofex.naikan.model.serializer.json;

import com.enofex.naikan.model.Bom;
import com.enofex.naikan.model.serializer.SerializerException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public final class JsonSerializer10 extends AbstractJsonSerializer {

  @Override
  public Version getSchemaVersion() {
    return Version.VERSION_10;
  }

  @Override
  public File toFile(Bom bom, String fileName) {
    return toFile(bom, fileName, true);
  }

  @Override
  public File toFile(Bom bom, String fileName, boolean prettyPrint) {
    try (FileWriter writer = new FileWriter(fileName)) {
      writer.write(toJson(modifyBom(bom), prettyPrint));

      return new File(fileName);
    } catch (SerializerException | IOException e) {
      return null;
    }
  }

  @Override
  public JsonNode toJsonNode(Bom bom) {
    try {
      return mapper().readTree(toJson(modifyBom(bom), false));
    } catch (SerializerException | JsonProcessingException e) {
      return null;
    }
  }

  @Override
  public String toJsonString(Bom bom) {
    try {
      return toJson(modifyBom(bom), true);
    } catch (SerializerException e) {
      return "";
    }
  }

  @Override
  public String toString(Bom bom) {
    try {
      return toJson(modifyBom(bom), false);
    } catch (SerializerException e) {
      return "";
    }
  }
}