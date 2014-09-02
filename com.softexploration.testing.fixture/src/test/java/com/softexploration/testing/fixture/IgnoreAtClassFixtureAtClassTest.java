package com.softexploration.testing.fixture;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import com.softexploration.testing.fixture.execution.FixtureExecutionContext;
import com.softexploration.testing.fixture.suite.FixtureSuite;
import com.softexploration.testing.fixture.suite.RegistrantsFixtureSuite;

@Fixture(value = IgnoreAtClassFixtureAtClassTest.INCREMENT_NUMBER_A)
@IgnoreFixture
public class IgnoreAtClassFixtureAtClassTest {

	static final String INCREMENT_NUMBER_A = "incrementNumberA";

	static int numberA;

	@Rule
	public FixtureRule fixtureRule = new FixtureRule(createFixtureSuite());

	static FixtureSuite createFixtureSuite() {
		RegistrantsFixtureSuite fixtureSuite = new RegistrantsFixtureSuite();
		fixtureSuite.registerFixture(INCREMENT_NUMBER_A, IgnoreAtClassFixtureAtClassTest::incrementNumberAby2,
				IgnoreAtClassFixtureAtClassTest::incrementNumberAby4);
		return fixtureSuite;
	}

	static void incrementNumberAby2(final FixtureExecutionContext ct) {
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
	public void testFixtureExecution() {
		Assert.assertEquals(1, numberA);
	}

	@AfterClass
	public static void afterClass() {
		Assert.assertEquals(1, numberA);
	}

}
