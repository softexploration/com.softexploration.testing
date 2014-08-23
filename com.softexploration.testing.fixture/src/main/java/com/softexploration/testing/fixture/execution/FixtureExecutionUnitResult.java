package com.softexploration.testing.fixture.execution;

/**
 * {@link com.softexploration.testing.fixture.Fixture}'s execution unit result
 * 
 * @param <T>
 *            - result's value type
 */
public class FixtureExecutionUnitResult<T> {

	private T value;

	/**
	 * @param value
	 *            - result object
	 */
	public FixtureExecutionUnitResult(final T value) {
		this.value = value;
	}

	/**
	 * @return result object
	 */
	public T get() {
		return value;
	}

	/**
	 * @return is result object available
	 */
	public boolean isPresent() {
		return value != null;
	}
}
