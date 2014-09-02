package com.softexploration.testing.fixture;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import com.softexploration.testing.fixture.execution.FixtureExecutionContext;
import com.softexploration.testing.fixture.suite.FixtureSuite;
import com.softexploration.testing.fixture.suite.RegistrantsFixtureSuite;

public class FixtureBeforeActiveAfterActiveTest {

	static final String INCREMENT_NUMBER_A = "incrementNumberA";

	static int numberA;

	@Rule
	public FixtureRule fixtureRule = new FixtureRule(createFixtureSuite());

	static FixtureSuite createFixtureSuite() {
		RegistrantsFixtureSuite fixtureSuite = new RegistrantsFixtureSuite();
		fixtureSuite.registerFixture(INCREMENT_NUMBER_A, FixtureBeforeActiveAfterActiveTest::incrementNumberAby2,
				FixtureBeforeActiveAfterActiveTest::incrementNumberAby4);
		return fixtureSuite;
	}

	static void incrementNumberAby2(final FixtureExecutionContext ctx) {
		numberA += 2;
	}

	static void incrementNumberAby4(final FixtureExecutionContext ct) {
		numberA += 4;
	}

	@BeforeClass
	public static void beforeClass() {
		numberA = 1;
	}

	@Test
	@Fixture(value = INCREMENT_NUMBER_A, executeBeforeTest = true, executeAfterTest = true)
	public void testFixtureExecution() {
		// numberA = 1 + 2 = 3
		Assert.assertEquals(3, numberA);
	}

	@AfterClass
	public static void afterClass() {
		// numberA = 3 + 4 = 7
		Assert.assertEquals(7, numberA);
	}

}
