package com.softexploration.testing.fixture.suite;

import com.softexploration.testing.fixture.execution.FixtureExecutionUnit;

/**
 * Associates fixtures names of a
 * {@link com.softexploration.testing.fixture.Fixture} with their respectively
 * before and after execution code definitions
 */
public interface FixtureSuite {

	/**
	 * @param fixtureName
	 * @return before-test's
	 *         {@link com.softexploration.testing.fixture.execution.FixtureExecutionUnit}
	 */
	FixtureExecutionUnit getBeforeTest(final String fixtureName);

	/**
	 * @param fixtureName
	 * @return after-test's
	 *         {@link com.softexploration.testing.fixture.execution.FixtureExecutionUnit}
	 */
	FixtureExecutionUnit getAfterTest(final String fixtureName);
}
