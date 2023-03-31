package io.naikan.model.architecture;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

class ArchitectureTest {

    @TestFactory
    Collection<DynamicTest> testArchitecture() {
        return ArchUnitTestConfig.builder()
                .build();
    }
}
