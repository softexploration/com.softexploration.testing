package com.softexploration.testing.fixture.execution;

/**
 * Code to be execute as a part of a fixture
 */
public interface FixtureExecutionUnit {

	FixtureExecutionUnit NOP = new FixtureExecutionUnit() {
		@Override
		public void execute() {
			// do nothing
		}
	};

	void execute();
}
