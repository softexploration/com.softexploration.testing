package com.softexploration.testing.fixture;

/**
 * A {@link com.softexploration.testing.fixture.Fixture} with a certain name
 * already exist
 */
public class FixtureAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 254667113459967950L;

	public FixtureAlreadyExistsException() {
	}

	public FixtureAlreadyExistsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FixtureAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}

	public FixtureAlreadyExistsException(String message) {
		super(message);
	}

	public FixtureAlreadyExistsException(Throwable cause) {
		super(cause);
	}

}
