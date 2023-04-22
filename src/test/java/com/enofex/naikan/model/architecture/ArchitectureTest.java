package com.enofex.naikan.model.architecture;


import com.enofex.naikan.test.architecture.ArchUnitTestsConfig;
import java.util.Collection;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

class ArchitectureTest {

  @TestFactory
  Collection<DynamicTest> shouldFulfilArchitectureConstrains() {
    return ArchUnitTestsConfig.defaultConfig().getDynamicTests();
  }
}
