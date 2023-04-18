package io.naikan.model.validator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.net.URL;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import io.naikan.model.BomSchema;
import io.naikan.model.validator.DefaultValidator;
import io.naikan.test.model.Boms;

class DefaultValidatorTest {

  @TestFactory
  Collection<DynamicTest> dynamicTestsWithCollection() throws Exception {
    List<BomFile> files = getAllResources();

    List<DynamicTest> dynamicTests = new ArrayList<>();

    for (BomFile file : files) {
      if (file.name().endsWith(".json")) {
        BomSchema.Version schemaVersion;

        if (file.name().endsWith("-1.0.json")) {
          schemaVersion = BomSchema.Version.VERSION_10;
        } else {
          schemaVersion = null;
        }

        if (file.name().startsWith("valid") && schemaVersion != null) {
          dynamicTests.add(
              DynamicTest.dynamicTest(file.name(),
                  () -> assertTrue(isValidJson(schemaVersion, file))
              ));
        } else if (file.name().startsWith("invalid") && schemaVersion != null) {
          dynamicTests.add(
              DynamicTest.dynamicTest(file.name(),
                  () -> assertFalse(isValidJson(schemaVersion, file))
              ));
        }
      }
    }

    return dynamicTests;
  }

  private boolean isValidJson(BomSchema.Version version, BomFile file) {
    return new DefaultValidator().isValid(file.content(), version);
  }

  private List<BomFile> getAllResources() throws Exception {
    return new ArrayList<>(getResources("1.0/"));
  }

  private List<BomFile> getResources(String resourceDirectory) throws Exception {
    List<BomFile> files = new ArrayList<>();
    String dir = resourceDirectory;

    if (!resourceDirectory.endsWith("/")) {
      dir += "/";
    }

    URL url = Boms.class.getClassLoader().getResource(dir);

    try (FileSystem fileSystem = FileSystems.newFileSystem(url.toURI(), Collections.emptyMap())) {
      Files
          .walk(fileSystem.getPath(dir))
          .forEach(path -> {
                if (path.getFileName().toString().endsWith("json")) {
                  try {
                    files.add(new BomFile(path.getFileName().toString(), Files.readString(path)));
                  } catch (IOException e) {
                    throw new RuntimeException(e);
                  }
                }
              }
          );
    }

    return files;
  }

  private record BomFile(String name, String content) {

  }
}