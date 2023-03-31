package io.naikan.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SchemaValidatorsConfig;
import com.networknt.schema.SpecVersionDetector;

public abstract class BomSchema {

    public static final String NS_BOM_10 = "https://naikan.io/schema/bom/1.0";
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

    public JsonSchema jsonSchema(BomSchema.Version schemaVersion, ObjectMapper mapper) throws IOException {
        SchemaValidatorsConfig config = new SchemaValidatorsConfig();
        Map<String, String> offlineMappings = Map.of(
                "https://naikan.io/schema/bom-1.0.schema.json",
                getClass()
                        .getClassLoader()
                        .getResource("bom-1.0.schema.json")
                        .toExternalForm());
        config.setUriMappings(offlineMappings);
        JsonNode schemaNode = mapper.readTree(jsonSchemaAsStream(schemaVersion));
        JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersionDetector.detect(schemaNode));

        return factory.getSchema(schemaNode, config);
    }

    private InputStream jsonSchemaAsStream(BomSchema.Version schemaVersion) {
        return this.getClass().getClassLoader().getResourceAsStream("bom-1.0.schema.json");
    }
}