package com.softexploration.testing.fixture;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import com.softexploration.testing.fixture.execution.FixtureExecutionContext;
import com.softexploration.testing.fixture.execution.FixtureExecutionUnitResult;
import com.softexploration.testing.fixture.suite.FixtureSuite;

/**
 * Rule to handle a {@link com.softexploration.testing.fixture.Fixture}
 */
public class FixtureRule implements TestRule {

	private final FixtureSuite fixtureSuite;
	private final FixtureExecutionContext fixtureContext;

	/**
	 * @param fixtureSuite
	 */
	public FixtureRule(final FixtureSuite fixtureSuite) {
		this.fixtureSuite = fixtureSuite;
		fixtureContext = new FixtureExecutionContext(this);
	}

	@Override
	public Statement apply(final Statement base, final Description description) {
		return new FixtureStatement(base, description, fixtureSuite, fixtureContext);
	}

	/**
	 * @param clazz
	 *            - type of an expected result
	 * @return before-test's fixture optional result object
	 */
	public <T> T getBeforeTestFixtureResult(final Class<T> clazz) {
		if (isBeforeTestFixtureResultPresent(clazz)) {
			return getObjectFromResult(fixtureContext.getBeforeTestFixtureResult());
		} else {
			return null;
		}
	}

	/**
	 * @param clazz
	 *            - type of an expected result
	 * @return after-test's fixture optional result object
	 */
	public <T> T getAfterTestFixtureResult(final Class<T> clazz) {
		if (isAfterTestFixtureResultPresent(clazz)) {
			return getObjectFromResult(fixtureContext.getAfterTestFixtureResult());
		} else {
			return null;
		}
	}

	/**
	 * @param clazz
	 *            - type of an expected result
	 * @return before-test's fixture optional result object is available
	 */
	public <T> boolean isBeforeTestFixtureResultPresent(final Class<T> clazz) {
		if (fixtureContext.isBeforeTestFixtureResultObjectPresent()) {
			return clazz.isAssignableFrom(getObjectFromResult(fixtureContext.getBeforeTestFixtureResult()).getClass());
		} else {
			return false;
		}
	}

	/**
	 * @param clazz
	 *            - type of an expected result
	 * @return after-test's fixture optional result object is available
	 */
	public <T> boolean isAfterTestFixtureResultPresent(final Class<T> clazz) {
		if (fixtureContext.isAfterTestFixtureResultObjectPresent()) {
			return clazz.isAssignableFrom(getObjectFromResult(fixtureContext.getAfterTestFixtureResult()).getClass());
		} else {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	private <T> T getObjectFromResult(final FixtureExecutionUnitResult<?> fixtureResult) {
		return (T) fixtureResult.get();
	}
}
