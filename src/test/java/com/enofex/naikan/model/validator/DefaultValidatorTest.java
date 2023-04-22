package com.enofex.naikan.model.validator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.enofex.naikan.model.BomSchema;
import com.enofex.naikan.model.BomSchema.Version;
import com.enofex.naikan.test.model.Boms;
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

class DefaultValidatorTest {

  @TestFactory
  Collection<DynamicTest> dynamicTestsWithCollection() throws Exception {
    List<DynamicTest> dynamicTests = new ArrayList<>();

    for (Version schemaVersion : List.of(Version.VERSION_10)) {
      List<BomFile> files = getAllResourcesForVersion(schemaVersion);

      for (BomFile file : files) {
        if (file.name().endsWith(".json")) {

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
    }

    assertTrue(dynamicTests.size() > 0);

    return dynamicTests;
  }

  private boolean isValidJson(BomSchema.Version version, BomFile file) {
    return new DefaultValidator().isValid(file.content(), version);
  }

  private List<BomFile> getAllResourcesForVersion(Version bomSchemaVersion) throws Exception {
    List<BomFile> files = new ArrayList<>();
    String dir = bomSchemaVersion.version() + "/";
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