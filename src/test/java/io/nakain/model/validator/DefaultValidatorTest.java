package io.nakain.model.validator;

import io.naikan.model.BomSchema;
import io.naikan.model.validator.DefaultValidator;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.io.File;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DefaultValidatorTest {

    @TestFactory
    Collection<DynamicTest> dynamicTestsWithCollection() throws Exception {
        List<String> files = getAllResources();
        List<DynamicTest> dynamicTests = new ArrayList<>();

        for (String file : files) {
            if (file.endsWith(".json")) {
                BomSchema.Version schemaVersion;

                if (file.endsWith("-1.0.json")) {
                    schemaVersion = BomSchema.Version.VERSION_10;
                } else {
                    schemaVersion = null;
                }

                if (file.startsWith("valid") && schemaVersion != null) {
                    dynamicTests.add(DynamicTest.dynamicTest(file, () -> assertTrue(isValidJson(schemaVersion, "/" + schemaVersion.version() + "/" + file), file))
                    );
                } else if (file.startsWith("invalid") && schemaVersion != null) {
                    dynamicTests.add(DynamicTest.dynamicTest(file, () -> assertFalse(
                            isValidJson(schemaVersion, "/" + schemaVersion.version() + "/" + file), file)));
                }
            }
        }

        return dynamicTests;
    }

    private boolean isValidJson(BomSchema.Version version, String resource) throws Exception {
        File file = new File(this.getClass().getResource(resource).getFile());

        return new DefaultValidator().isValid(file, version);
    }

    private List<String> getAllResources() throws Exception {
        return new ArrayList<>(getResources("1.0/"));
    }

    private List<String> getResources(String resourceDirectory) throws Exception {
        List<String> files = new ArrayList<>();
        String dir = resourceDirectory;

        if (!resourceDirectory.endsWith("/")) {
            dir += "/";
        }

        try (InputStream in = this.getClass().getClassLoader().getResourceAsStream(dir)) {
            if (in != null) {
                files.addAll(IOUtils.readLines(in, StandardCharsets.UTF_8));
            }
        }

        return files;
    }
}