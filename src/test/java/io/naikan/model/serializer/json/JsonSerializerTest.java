package io.naikan.model.serializer.json;

import static io.naikan.test.model.Boms.validBom0asInputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.naikan.model.Bom;
import io.naikan.model.BomSchema;
import io.naikan.model.deserializer.DeserializerFactory;
import io.naikan.model.deserializer.json.DefaultJsonDeserializer;
import io.naikan.model.serializer.SerializerFactory;
import io.naikan.model.validator.DefaultValidator;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
  void schema10ShouldBeValid() {
    Bom bom = DeserializerFactory.newJsonDeserializer().of(validBom0asInputStream());

    JsonSerializer serializer = (JsonSerializer) SerializerFactory.newJsonSerializer(
        BomSchema.Version.VERSION_10);
    assertTrue(serializer instanceof JsonSerializer10);
    assertEquals(BomSchema.Version.VERSION_10, serializer.getSchemaVersion());

    File file = serializer.toFile(bom, this.tempFile.getAbsolutePath());
    assertTrue(new DefaultValidator().isValid(file, BomSchema.Version.VERSION_10));
  }

  @Test
  void json10ShouldBeSame() {
    Bom originalBom = DeserializerFactory.newJsonDeserializer().of(validBom0asInputStream());

    JsonSerializer generator = (JsonSerializer) SerializerFactory
        .newJsonSerializer(BomSchema.Version.VERSION_10);
    File file = generator.toFile(originalBom, this.tempFile.getAbsolutePath());
    Bom generatedBom = new DefaultJsonDeserializer().of(file);

    assertEquals(originalBom, generatedBom);
  }

}