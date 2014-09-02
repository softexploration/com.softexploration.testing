package com.softexploration.testing.fixture;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import com.softexploration.testing.fixture.execution.FixtureExecutionContext;
import com.softexploration.testing.fixture.execution.FixtureExecutionUnit;
import com.softexploration.testing.fixture.suite.FixtureSuite;
import com.softexploration.testing.fixture.suite.RegistrantsFixtureSuite;

public class FixtureResultTest {

	public static final String NUMBER_A = "numberA";
	public static final String NOP = "nop";

	static int numberA;

	@Rule
	public FixtureRule fixtureRule = new FixtureRule(createFixtureSuite());

	static FixtureSuite createFixtureSuite() {
		RegistrantsFixtureSuite fixtureSuite = new RegistrantsFixtureSuite();
		fixtureSuite.registerFixture(NUMBER_A, FixtureResultTest::add2ToNumberA, FixtureExecutionUnit.NOP);
		fixtureSuite.registerFixture(NOP, FixtureExecutionUnit.NOP, FixtureExecutionUnit.NOP);
		return fixtureSuite;
	}

	static void add2ToNumberA(final FixtureExecutionContext ctx) {
		ctx.setBeforeTestFixtureResult(Integer.valueOf(numberA + 2));
	}

	@BeforeClass
	public static void beforeClass() {
		numberA = 1;
	}

	@Test
	@Fixture(value = NUMBER_A)
	public void testBeforeIntegerResult() {
		Assert.assertTrue(fixtureRule.isBeforeTestFixtureResultPresent(Integer.class));
		Assert.assertEquals(3, fixtureRule.getBeforeTestFixtureResult(Integer.class).intValue());
	}

	@Test
	@Fixture(value = NUMBER_A)
	public void testBeforeDoubleResult() {
		Assert.assertFalse(fixtureRule.isBeforeTestFixtureResultPresent(Double.class));
	}

	@Test
	@Fixture(value = NOP)
	public void testNop() {
		Assert.assertFalse(fixtureRule.isBeforeTestFixtureResultPresent(Object.class));
	}

}
