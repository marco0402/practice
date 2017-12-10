package com.mcapp.practice.java8.lambda;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

public class LambdaPracticeTest {
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
	public void testToStringWhenAllCasesReturnStaticValue() {
		// arrange
		LambdaPractice lp = new LambdaPractice();
		String expected = "This is calling LambdaPractice toString method";
		String message = "Result should always match value: " + expected;

		// action
		String actual = lp.toString();

		// assert
		assertEquals(message, expected, actual);
	}

	@Test
	public void testMainWhenAllCasesReturnStaticValue() {
		// arrange
		String[] args = null;
		String expected = "This is calling LambdaPractice toString method\n";
		expected += "100\n";
		expected += "200\n";
		expected += "300\n";
		expected += "123\n";
		String message = "Result should always match value: " + expected;

		// action
		LambdaPractice.main(args);
		String actual = systemOutRule.getLogWithNormalizedLineSeparator();

		// assert
		assertEquals(message, expected, actual);
	}
}
