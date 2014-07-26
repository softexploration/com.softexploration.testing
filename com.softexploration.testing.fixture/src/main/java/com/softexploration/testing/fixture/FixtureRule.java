package com.softexploration.testing.fixture;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import com.softexploration.testing.fixture.suite.FixtureSuite;

public class FixtureRule implements TestRule {

	private final FixtureSuite fixtureSuite;

	public FixtureRule(final FixtureSuite fixtureSuite) {
		this.fixtureSuite = fixtureSuite;
	}

	@Override
	public Statement apply(final Statement base, final Description description) {
		return new FixtureStatement(base, description, fixtureSuite);
	}
}
