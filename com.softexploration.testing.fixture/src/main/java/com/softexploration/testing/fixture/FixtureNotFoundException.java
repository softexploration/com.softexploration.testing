package com.softexploration.testing.fixture;

/**
 * A {@link com.softexploration.testing.fixture.Fixture} with a certain name
 * cannot be found
 */
public class FixtureNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -8703144903338040751L;

	public FixtureNotFoundException() {
	}

	public FixtureNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FixtureNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public FixtureNotFoundException(String message) {
		super(message);
	}

	public FixtureNotFoundException(Throwable cause) {
		super(cause);
	}

}
