package com.enofex.naikan.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SchemaValidatorsConfig;
import com.networknt.schema.SpecVersionDetector;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public abstract class BomSchema {

  public static final String NS_BOM_10 = "https://enofex.github.io/naikan/schema/bom/1.0";
  public static final Version VERSION_LATEST = Version.VERSION_10;

  public enum Version {
    VERSION_10(BomSchema.NS_BOM_10, "1.0");

    private final String namespace;
    private final String version;

    Version(String namespace, String version) {
      this.namespace = namespace;
      this.version = version;
    }

    public String namespace() {
      return this.namespace;
    }

    public String version() {
      return this.version;
    }
  }

  public JsonSchema jsonSchema(BomSchema.Version schemaVersion, ObjectMapper mapper)
      throws IOException {
    SchemaValidatorsConfig config = new SchemaValidatorsConfig();
    Map<String, String> offlineMappings = Map.of(
        "https://enofex.github.io/naikan/schema/bom-1.0.schema.json",
        getClass()
            .getClassLoader()
            .getResource(schemaFile(schemaVersion))
            .toExternalForm());
    config.setUriMappings(offlineMappings);
    JsonNode schemaNode = mapper.readTree(jsonSchemaAsStream(schemaVersion));
    JsonSchemaFactory factory = JsonSchemaFactory.getInstance(
        SpecVersionDetector.detect(schemaNode));

    return factory.getSchema(schemaNode, config);
  }

  private InputStream jsonSchemaAsStream(BomSchema.Version schemaVersion) {
    return this.getClass().getClassLoader().getResourceAsStream(schemaFile(schemaVersion));
  }

  private String schemaFile(BomSchema.Version schemaVersion) {
    if (Version.VERSION_10 == schemaVersion) {
      return "bom-1.0.schema.json";
    }

    return null;
  }
}