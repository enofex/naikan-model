package io.naikan.model.architecture;

import static com.tngtech.archunit.library.dependencies.SlicesRuleDefinition.slices;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import org.junit.jupiter.api.DynamicTest;

final class CyclicRules {

    private CyclicRules() {
    }

    static DynamicTest cyclicRules(ArchUnitTestConfig config) {
        return dynamicTest("There should be no cycles in the application",
                () -> slices().matching(config.getNamespace() + ".(*)..")
                        .should().beFreeOfCycles()
                        .check(config.getClasses()));
    }
}
