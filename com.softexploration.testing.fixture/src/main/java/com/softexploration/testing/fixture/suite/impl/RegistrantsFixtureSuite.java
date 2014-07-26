package com.softexploration.testing.fixture.suite.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.softexploration.testing.fixture.FixtureAlreadyExistsException;
import com.softexploration.testing.fixture.FixtureNotFoundException;
import com.softexploration.testing.fixture.execution.FixtureExecutionUnit;
import com.softexploration.testing.fixture.suite.FixtureSuite;

/**
 * Fixture suite with an ability to register a suite with a specified name and
 * before/after test code definitions
 */
public class RegistrantsFixtureSuite implements FixtureSuite {

	private final Map<String, Entry<FixtureExecutionUnit, FixtureExecutionUnit>> map = new HashMap<>();

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

	public void unregisterFixture(final String fixtureName) {
		validateFixtureExistence(fixtureName);
		map.remove(fixtureName);
	}

	public boolean exists(final String fixtureName) {
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
