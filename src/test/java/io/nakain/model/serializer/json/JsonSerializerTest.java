package io.nakain.model.serializer.json;

import io.naikan.model.Bom;
import io.naikan.model.BomSchema;
import io.naikan.model.deserializer.DeserializerFactory;
import io.naikan.model.deserializer.json.JsonDeserializer;
import io.naikan.model.serializer.SerializerFactory;
import io.naikan.model.serializer.json.JsonSerializer;
import io.naikan.model.serializer.json.JsonSerializer10;
import io.naikan.model.validator.DefaultValidator;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class JsonSerializerTest {

    private File tempFile;

    @BeforeEach
    void before() throws IOException {
        Path path = Files.createTempDirectory("naikan-model");
        this.tempFile = new File(path.toFile(), "bom.json");
    }

    @AfterEach
    void after() {
        this.tempFile.delete();
        this.tempFile.getParentFile().delete();
    }

    @Test
    void schema10ShouldBeValid() throws Exception {
        Bom bom = DeserializerFactory.newJsonDeserializer().of(this.getClass().getResourceAsStream("/1.0/valid-0-bom-1.0.json"));

        JsonSerializer serializer = SerializerFactory.newJsonSerializer(BomSchema.Version.VERSION_10);
        assertTrue(serializer instanceof JsonSerializer10);
        assertEquals(BomSchema.Version.VERSION_10, serializer.getSchemaVersion());

        File file = serializer.toFile(bom, this.tempFile.getAbsolutePath());
        assertTrue(new DefaultValidator().isValid(file, BomSchema.Version.VERSION_10));
    }

    @Test
    void json10ShouldBeSame() throws Exception {
        Bom originalBom = DeserializerFactory.newJsonDeserializer().of(IOUtils.toByteArray(this.getClass().getResourceAsStream("/1.0/valid-0-bom-1.0.json")));

        JsonSerializer generator = SerializerFactory.newJsonSerializer(BomSchema.Version.VERSION_10);
        File file = generator.toFile(originalBom, this.tempFile.getAbsolutePath());
        Bom generatedBom = new JsonDeserializer().of(file);

        assertEquals(originalBom, generatedBom);
    }

}