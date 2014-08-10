package com.softexploration.testing.fixture;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import com.softexploration.testing.fixture.suite.FixtureSuite;
import com.softexploration.testing.fixture.suite.RegistrantsFixtureSuite;

public class BeforeInactiveAfterInactiveExecutionsTest {

	public static final String INCREMENT_NUMBER_A = "incrementNumberA";

	@Rule
	public FixtureRule fixtureRule = new FixtureRule(createFixtureSuite());

	private static int numberA;

	private FixtureSuite createFixtureSuite() {
		RegistrantsFixtureSuite fixtureSuite = new RegistrantsFixtureSuite();
		fixtureSuite.registerFixture(INCREMENT_NUMBER_A,
				BeforeInactiveAfterInactiveExecutionsTest::incrementNumberAby2,
				BeforeInactiveAfterInactiveExecutionsTest::incrementNumberAby4);
		return fixtureSuite;
	}

	static private void incrementNumberAby2() {
		numberA += 2;
	}

	static private void incrementNumberAby4() {
		numberA += 4;
	}

	@BeforeClass
	public static void beforeClass() {
		numberA = 1;
	}

	@Test
	@Fixture(value = INCREMENT_NUMBER_A, executeBeforeTest = false, executeAfterTest = false)
	public void ttestFixtureExecutionest1() {
		// numberA = 1
		Assert.assertEquals(1, numberA);
	}

	@AfterClass
	public static void afterClass() {
		// numberA = 1
		Assert.assertEquals(1, numberA);
	}

}
