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
	 * @param fixtureContext
	 */
	public <T> void execute(final FixtureExecutionUnit fixtureExecutionUnit,
			final FixtureExecutionContext fixtureContext) {
		fixtureExecutionUnit.execute(fixtureContext);
	}
}
