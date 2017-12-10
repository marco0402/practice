package com.mcapp.practice.java8.datetime;

import static org.junit.Assert.assertTrue;

import java.util.regex.Pattern;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

public class DateTimePracticeTest {
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
		String expected = "UTC Clock Local Date: .*\n";
		expected += "UTC Clock Local Time: .*\n";
		expected += "UTC Clock Local Date Time: .*\n";
		expected += "UTC Clock Zoned Date Time: .*\n";
		expected += "Default Zone Clock Local Date: .*\n";
		expected += "Default Zone Clock Local Time: .*\n";
		expected += "Default Zone Clock Local Date Time: .*\n";
		expected += "Default Zone Clock Zoned Date Time: .*\n";
		expected += "Specific Zone Clock Local Date: .*\n";
		expected += "Specific Zone Clock Local Time: .*\n";
		expected += "Specific Zone Clock Local Date Time: .*\n";
		expected += "Specific Zone Clock Zoned Date Time: .*\n";
		expected += "Now Local Date: .*\n";
		expected += "Now Local Time: .*\n";
		expected += "Now Local Date Time: .*\n";
		expected += "Now Zoned Date Time: .*\n";
		expected += "Specific Zone Now Local Date: .*\n";
		expected += "Specific Zone Now Local Time: .*\n";
		expected += "Specific Zone Now Local Date Time: .*\n";
		expected += "Specific Zone Now Zoned Date Time: .*\n";
		expected += "Specific Value Local Date: .*\n";
		expected += "Specific Value Local Time: .*\n";
		expected += "Specific Value Local Date Time: .*\n";
		expected += "Specific Value Zoned Date Time: .*\n";
		expected += "Duration Days: .*\n";
		expected += "Duration Hours: .*\n";
		String message = "Result should always similar to: " + expected;

		// action
		DateTimePractice.main(args);
		String actual = systemOutRule.getLogWithNormalizedLineSeparator();

		// assert
		assertTrue(message, Pattern.matches(expected, actual));
	}
}
