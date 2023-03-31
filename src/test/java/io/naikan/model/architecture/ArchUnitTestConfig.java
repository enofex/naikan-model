package io.naikan.model.architecture;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;

import com.tngtech.archunit.core.domain.JavaClasses;

final class ArchUnitTestConfig {

    private static final String DEFAULT_NAMESPACE = "io.naikan.model.";

    private String namespace;
    private JavaClasses classes;
    private JavaClasses testClasses;

    private ArchUnitTestConfig() {
    }

    String getNamespace() {
        return this.namespace;
    }

    JavaClasses getClasses() {
        return this.classes;
    }

    JavaClasses getTestClasses() {
        return this.testClasses;
    }

    public static ArchUnitTestBuilder builder() {
        return new ArchUnitTestBuilder();
    }

    public static final class ArchUnitTestBuilder {

        private ArchUnitTestBuilder() {
        }

        public Collection<DynamicTest> build() {
            ArchUnitTestConfig config = new ArchUnitTestConfig();
            config.namespace = DEFAULT_NAMESPACE;
            config.classes = Namespace.classes(config.namespace);
            config.testClasses = Namespace.testClasses(config.namespace);

            return new ArchUnitTestsFactory(config).createTests();
        }
    }
}
