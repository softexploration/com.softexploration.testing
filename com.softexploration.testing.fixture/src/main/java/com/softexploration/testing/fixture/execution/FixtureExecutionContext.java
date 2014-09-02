package com.softexploration.testing.fixture.execution;

import com.softexploration.testing.fixture.FixtureRule;

/**
 * Context for {@link com.softexploration.testing.fixture.Fixture}'s execution
 * units
 */
public class FixtureExecutionContext {

	private final FixtureRule fixtureRule;

	private FixtureExecutionUnitResult<?> beforeTestFixtureResult;
	private FixtureExecutionUnitResult<?> afterTestFixtureResult;

	/**
	 * @param fixtureRule
	 */
	public FixtureExecutionContext(final FixtureRule fixtureRule) {
		this.fixtureRule = fixtureRule;
	}

	/**
	 * @return fixtureRule
	 */
	public FixtureRule getFixtureRule() {
		return fixtureRule;
	}

	/**
	 * @return result of before-test's fixture execution unit
	 */
	public FixtureExecutionUnitResult<?> getBeforeTestFixtureResult() {
		return beforeTestFixtureResult;
	}

	/**
	 * @return result of after-test's fixture execution unit
	 */
	public FixtureExecutionUnitResult<?> getAfterTestFixtureResult() {
		return afterTestFixtureResult;
	}

	/**
	 * @param optional
	 *            result of before-test's fixture execution unit
	 */
	public <T> void setBeforeTestFixtureResult(final T result) {
		this.beforeTestFixtureResult = new FixtureExecutionUnitResult<T>(result);
	}

	/**
	 * @param optional
	 *            result of after-test's fixture execution unit
	 */
	public <T> void setAfterTestFixtureResult(final T result) {
		this.afterTestFixtureResult = new FixtureExecutionUnitResult<T>(result);
	}

	/**
	 * @return before-test's fixture optional result object is available
	 */
	public boolean isBeforeTestFixtureResultObjectPresent() {
		return beforeTestFixtureResult != null && beforeTestFixtureResult.isPresent();
	}

	/**
	 * @return after-test's fixture optional result object is available
	 */
	public boolean isAfterTestFixtureResultObjectPresent() {
		return afterTestFixtureResult != null && afterTestFixtureResult.isPresent();
	}

}
