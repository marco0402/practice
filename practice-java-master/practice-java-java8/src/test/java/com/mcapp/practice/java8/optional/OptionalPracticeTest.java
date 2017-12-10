package com.mcapp.practice.java8.optional;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

public class OptionalPracticeTest {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

	@Test
	public void testMainWhenAllCasesReturnStaticValue() {
		// arrange
		String[] args = null;
		String expected = "User Input 1 Present: false\n";
		expected += "User Input 1 Value: Not Available\n";
		expected += "User Input 1 Map: Not Available\n";
		expected += "User Input 2 Present: true\n";
		expected += "User Input 2 Value: \n";
		expected += "User Input 2 Map: Value  Available\n";
		expected += "User Input 3 Present: true\n";
		expected += "User Input 3 Value: Marco\n";
		expected += "User Input 3 Map: Value Marco Available\n";

		String message = "Result should always match value: " + expected;

		// action
		OptionalPractice.main(args);
		String actual = systemOutRule.getLogWithNormalizedLineSeparator();

		// assert
		assertEquals(message, expected, actual);
	}
}
