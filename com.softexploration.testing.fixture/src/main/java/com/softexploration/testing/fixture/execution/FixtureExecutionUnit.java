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
		public void execute() {
			// do nothing
		}
	};

	/**
	 * Execute the unit
	 */
	void execute();
}
