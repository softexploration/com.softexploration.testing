package com.softexploration.testing.fixture;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import com.softexploration.testing.fixture.suite.FixtureSuite;
import com.softexploration.testing.fixture.suite.RegistrantsFixtureSuite;

@Fixture(value = IgnoreAtMethodFixtureAtClassTest.INCREMENT_NUMBER_A)
public class IgnoreAtMethodFixtureAtClassTest {

	public static final String INCREMENT_NUMBER_A = "incrementNumberA";

	@Rule
	public FixtureRule fixtureRule = new FixtureRule(createFixtureSuite());

	private static int numberA;

	private FixtureSuite createFixtureSuite() {
		RegistrantsFixtureSuite fixtureSuite = new RegistrantsFixtureSuite();
		fixtureSuite.registerFixture(INCREMENT_NUMBER_A, IgnoreAtMethodFixtureAtClassTest::incrementNumberAby2,
				IgnoreAtMethodFixtureAtClassTest::incrementNumberAby4);
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
	@IgnoreFixture
	public void testFixtureExecution() {
		Assert.assertEquals(1, numberA);
	}

	@AfterClass
	public static void afterClass() {
		Assert.assertEquals(1, numberA);
	}

}
