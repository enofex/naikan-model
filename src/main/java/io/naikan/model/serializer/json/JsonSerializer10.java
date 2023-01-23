package io.naikan.model.serializer.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import io.naikan.model.Bom;
import io.naikan.model.serializer.SerializerException;

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
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(toJson(modifyBom(bom), true));

            return new File(fileName);
        } catch (SerializerException | IOException e) {
            return null;
        }
    }

    @Override
    public JsonNode toJsonNode(Bom bom) {
        try {
            return getMapper().readTree(toJson(modifyBom(bom), false));
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