package com.softexploration.testing.fixture.suite;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.softexploration.testing.fixture.FixtureAlreadyExistsException;
import com.softexploration.testing.fixture.FixtureNotFoundException;
import com.softexploration.testing.fixture.execution.FixtureExecutionUnit;

/**
 * A suite of fixtures with the ability to register a suite with a specified
 * name and before/after test code definitions
 */
public class RegistrantsFixtureSuite implements FixtureSuite {

	private final Map<String, Entry<FixtureExecutionUnit, FixtureExecutionUnit>> map = new HashMap<>();

	/**
	 * Register a fixture. If a fixture with the same {@code fixtureName}
	 * already exists then it is replaced.
	 * 
	 * @param fixtureName
	 * @param beforeTest
	 * @param afterTest
	 */
	public void registerFixture(final String fixtureName, final FixtureExecutionUnit beforeTest,
			final FixtureExecutionUnit afterTest) {
		validateFixtureNonExistence(fixtureName);
		map.put(fixtureName, new java.util.AbstractMap.SimpleEntry<>(getNotNullInstance(beforeTest),
				getNotNullInstance(afterTest)));
	}

	private void validateFixtureNonExistence(final String fixtureName) {
		if (map.containsKey(fixtureName)) {
			throw new FixtureAlreadyExistsException("Fixture [" + fixtureName + "] already exists");
		}
	}

	private FixtureExecutionUnit getNotNullInstance(final FixtureExecutionUnit fixtureExecutionUnit) {
		return fixtureExecutionUnit == null ? FixtureExecutionUnit.NOP : fixtureExecutionUnit;
	}

	/**
	 * Unregister a fixture. If the fixture does not exist then nothing happens.
	 * 
	 * @param fixtureName
	 */
	public void unregisterFixture(final String fixtureName) {
		validateFixtureExistence(fixtureName);
		map.remove(fixtureName);
	}

	/**
	 * @param fixtureName
	 * @return Informs whether given {@code fixtureName} is already registered
	 */
	public boolean isRegistered(final String fixtureName) {
		return map.containsKey(fixtureName);
	}

	@Override
	public FixtureExecutionUnit getBeforeTest(final String fixtureName) {
		validateFixtureExistence(fixtureName);
		return map.get(fixtureName).getKey();
	}

	@Override
	public FixtureExecutionUnit getAfterTest(final String fixtureName) {
		validateFixtureExistence(fixtureName);
		return map.get(fixtureName).getValue();
	}

	private void validateFixtureExistence(final String fixtureName) {
		if (!map.containsKey(fixtureName)) {
			throw new FixtureNotFoundException("Fixture [" + fixtureName + "] does not exist");
		}
	}

}
