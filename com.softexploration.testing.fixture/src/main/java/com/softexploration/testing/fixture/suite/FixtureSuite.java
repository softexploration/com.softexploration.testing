package com.softexploration.testing.fixture.suite;

import com.softexploration.testing.fixture.execution.FixtureExecutionUnit;

/**
 * Associates fixtures names with their respectively before and after execution
 * code definitions
 */
public interface FixtureSuite {

	FixtureExecutionUnit getBeforeTest(final String fixtureName);

	FixtureExecutionUnit getAfterTest(final String fixtureName);
}
