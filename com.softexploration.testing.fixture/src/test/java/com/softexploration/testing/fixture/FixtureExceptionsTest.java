package com.softexploration.testing.fixture;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import com.softexploration.testing.fixture.execution.FixtureExecutionUnit;
import com.softexploration.testing.fixture.suite.FixtureSuite;
import com.softexploration.testing.fixture.suite.RegistrantsFixtureSuite;

public class FixtureExceptionsTest {

	@Test
	public void testFixtureNotFound() {
		Result result = JUnitCore.runClasses(InternalFixtureNotFound.class);
		Assert.assertEquals(1, result.getFailureCount());
		Assert.assertEquals(FixtureNotFoundException.class, result.getFailures().get(0).getException().getClass());
	}

	@Test
	public void testFixtureAlreadyExists() {
		Result result = JUnitCore.runClasses(InternalFixtureAlreadyExists.class);
		Assert.assertEquals(1, result.getFailureCount());
		Assert.assertEquals(FixtureAlreadyExistsException.class, result.getFailures().get(0).getException().getClass());
	}

	public static class InternalFixtureNotFound {

		@Rule
		public FixtureRule fixtureRule = new FixtureRule(createFixtureSuite());

		private FixtureSuite createFixtureSuite() {
			final RegistrantsFixtureSuite fixtureSuite = new RegistrantsFixtureSuite();
			fixtureSuite.registerFixture("fixture1", FixtureExecutionUnit.NOP, FixtureExecutionUnit.NOP);
			return fixtureSuite;
		}

		@Test
		@Fixture("fixture2")
		public void fixtureNotFoundTest() {
		}

	}

	public static class InternalFixtureAlreadyExists {

		@Rule
		public FixtureRule fixtureRule = new FixtureRule(createFixtureSuite());

		private FixtureSuite createFixtureSuite() {
			final RegistrantsFixtureSuite fixtureSuite = new RegistrantsFixtureSuite();
			fixtureSuite.registerFixture("fixture1", FixtureExecutionUnit.NOP, FixtureExecutionUnit.NOP);
			fixtureSuite.registerFixture("fixture1", FixtureExecutionUnit.NOP, FixtureExecutionUnit.NOP);
			return fixtureSuite;
		}

		@Test
		public void testNothing() {
		}

	}
}
