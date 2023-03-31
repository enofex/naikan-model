package io.naikan.model.architecture;

import static io.naikan.model.architecture.CyclicRules.cyclicRules;
import static io.naikan.model.architecture.NamingRules.namingRules;
import static io.naikan.model.architecture.TestingRules.testingRules;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.DynamicTest;

class ArchUnitTestsFactory {

    private final ArchUnitTestConfig config;
    private final List<DynamicTest> dynamicTests;

    ArchUnitTestsFactory(ArchUnitTestConfig config) {
        this.config = config;
        this.dynamicTests = new ArrayList<>();
    }

    Collection<DynamicTest> createTests() {
        this.dynamicTests.add(namingRules(this.config));
        this.dynamicTests.add(cyclicRules(this.config));
        this.dynamicTests.addAll(testingRules(this.config));

        return this.dynamicTests;
    }
}
