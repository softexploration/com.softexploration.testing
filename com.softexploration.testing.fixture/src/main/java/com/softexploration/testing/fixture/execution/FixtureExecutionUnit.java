package com.softexploration.testing.fixture.execution;

/**
 * Unit of code to be executed as a part of a
 * {@link com.softexploration.testing.fixture.Fixture}
 */
public interface FixtureExecutionUnit {

	/**
	 * Predefined No Operation fixture execution unit
	 */
	FixtureExecutionUnit NOP = new FixtureExecutionUnit() {
		@Override
		public void execute(final FixtureExecutionContext context) {
			// do nothing
		}
	};

	/**
	 * Execute the unit
	 * 
	 * @param context
	 *            - fixture's execution context
	 */
	void execute(final FixtureExecutionContext context);

}
