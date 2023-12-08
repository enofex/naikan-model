package com.enofex.naikan.model.serializer.json;


import static com.enofex.naikan.test.model.Boms.validBom0asInputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.enofex.naikan.model.Bom;
import com.enofex.naikan.model.BomSchema;
import com.enofex.naikan.model.deserializer.DeserializerFactory;
import com.enofex.naikan.model.deserializer.json.DefaultJsonDeserializer;
import com.enofex.naikan.model.serializer.SerializerFactory;
import com.enofex.naikan.model.validator.DefaultValidator;
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
  void shouldBeValid() {
    Bom bom = DeserializerFactory.newJsonDeserializer().of(validBom0asInputStream());

    JsonSerializer serializer = (JsonSerializer) SerializerFactory.newJsonSerializer(
        BomSchema.Version.VERSION_10);
    assertInstanceOf(JsonSerializer10.class, serializer);
    assertEquals(BomSchema.Version.VERSION_10, serializer.getSchemaVersion());

    File file = serializer.toFile(bom, this.tempFile.getAbsolutePath());
    assertTrue(new DefaultValidator().isValid(file, BomSchema.Version.VERSION_10));
  }

  @Test
  void shouldBeSame() {
    Bom originalBom = DeserializerFactory.newJsonDeserializer().of(validBom0asInputStream());

    JsonSerializer generator = (JsonSerializer) SerializerFactory
        .newJsonSerializer(BomSchema.Version.VERSION_10);
    File file = generator.toFile(originalBom, this.tempFile.getAbsolutePath());
    Bom generatedBom = new DefaultJsonDeserializer().of(file);

    assertEquals(originalBom, generatedBom);
  }

}