package io.naikan.model.architecture;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import io.naikan.test.architecture.ArchUnitTestsFactory;

class ArchitectureTest {

    @TestFactory
    Collection<DynamicTest> testArchitecture() {
        return ArchUnitTestsFactory.createTests();
    }
}
