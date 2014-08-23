package com.softexploration.testing.fixture;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The annotation at a method level tells the
 * {@link com.softexploration.testing.fixture.FixtureRule} to apply a fixture at
 * a given name to the test method.
 * 
 * When the annotation appears at a class level then it is considered as a
 * default fixture for all test methods without the
 * {@link com.softexploration.testing.fixture.Fixture} annotation within a
 * current test class. It is true unless a method or a class is marked with
 * {@link com.softexploration.testing.fixture.IgnoreFixture} annotation.
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.TYPE })
public @interface Fixture {

	/**
	 * @return fixture name
	 */
	String value();

	/**
	 * @return before-test's fixture code will be executed
	 */
	boolean executeBeforeTest() default true;

	/**
	 * @return after-test's fixture code will be executed
	 */
	boolean executeAfterTest() default true;
}
