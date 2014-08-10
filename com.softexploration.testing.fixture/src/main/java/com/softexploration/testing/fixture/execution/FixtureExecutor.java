package com.softexploration.testing.fixture.execution;

/**
 * Executes an object of
 * {@link com.softexploration.testing.fixture.execution.FixtureExecutionUnit}
 */
public class FixtureExecutor {

	/**
	 * Execute given {@code fixtureExecutionUnit}
	 * 
	 * @param fixtureExecutionUnit
	 */
	public void execute(final FixtureExecutionUnit fixtureExecutionUnit) {
		fixtureExecutionUnit.execute();
	}
}
