package com.softexploration.testing.fixture;

import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import com.softexploration.testing.fixture.execution.FixtureExecutor;
import com.softexploration.testing.fixture.suite.FixtureSuite;

/**
 * The {@link org.junit.runners.model.Statement} implementation for
 * {@link com.softexploration.testing.fixture.FixtureRule}'s purposes
 */
public class FixtureStatement extends Statement {

	private final Statement base;
	private final Description description;
	private final FixtureSuite fixtureSuite;
	private final FixtureExecutor fixtureExecutor = new FixtureExecutor();

	private Fixture activeFixture;

	public FixtureStatement(final Statement base, final Description description, final FixtureSuite fixtureSuite) {
		this.base = base;
		this.description = description;
		this.fixtureSuite = fixtureSuite;
	}

	@Override
	public void evaluate() throws Throwable {
		if (isFixtureIgnored()) {
			evaluateWithoutFixture();
		} else {
			evaluateWithFixture();
		}
	}

	private boolean isFixtureIgnored() {
		return isFixtureIgnoredAtClass() || isFixtureIgnoredAtMethod();
	}

	private boolean isFixtureIgnoredAtClass() {
		return description.getTestClass().getAnnotation(IgnoreFixture.class) != null;
	}

	private boolean isFixtureIgnoredAtMethod() {
		return description.getAnnotation(IgnoreFixture.class) != null;
	}

	private void evaluateWithoutFixture() throws Throwable {
		base.evaluate();
	}

	private void evaluateWithFixture() throws Throwable {
		preprocessFixtureConfiguration();
		evaluateBeforeTestExecution();
		base.evaluate();
		evaluateAfterTestExecution();
	}

	private void preprocessFixtureConfiguration() {
		resolveActiveFixture();
	}

	private void resolveActiveFixture() {
		if (isFixtureAtMethodPresent()) {
			activeFixture = getFixtureAtMethod();
		} else if (isFixtureAtClassPresent()) {
			activeFixture = getFixtureAtClass();
		}
	}

	private boolean isFixtureAtMethodPresent() {
		return getFixtureAtMethod() != null;
	}

	private Fixture getFixtureAtMethod() {
		return description.getAnnotation(Fixture.class);
	}

	private boolean isFixtureAtClassPresent() {
		return getFixtureAtClass() != null;
	}

	private Fixture getFixtureAtClass() {
		return description.getTestClass().getAnnotation(Fixture.class);
	}

	private void evaluateBeforeTestExecution() {
		if (shouldExecuteBeforeTest()) {
			fixtureExecutor.execute(fixtureSuite.getBeforeTest(getActiveFixtureName()));
		}
	}

	private boolean shouldExecuteBeforeTest() {
		return isActiveFixturePresent() && getActiveFixture().executeBeforeTest();
	}

	private boolean isActiveFixturePresent() {
		return getActiveFixture() != null;
	}

	private Fixture getActiveFixture() {
		return activeFixture;
	}

	private String getActiveFixtureName() {
		return getActiveFixture().value();
	}

	private void evaluateAfterTestExecution() {
		if (shouldExecuteAfterTest()) {
			fixtureExecutor.execute(fixtureSuite.getAfterTest(getActiveFixtureName()));
		}
	}

	private boolean shouldExecuteAfterTest() {
		return isActiveFixturePresent() && getActiveFixture().executeAfterTest();
	}

}
