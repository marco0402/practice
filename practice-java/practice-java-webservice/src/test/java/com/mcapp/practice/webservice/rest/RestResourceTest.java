package com.mcapp.practice.webservice.rest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RestResourceTest {
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

	@Test
	public void testDefaultServiceWhenAllCasesReturnStaticValue() {
		// arrange
		RestResource rr = new RestResource();
		String expected = "Default Service";
		String message = "Result should always match value: " + expected;

		// action
		String actual = rr.defaultService();

		// assert
		assertEquals(message, expected, actual);
	}

	@Test
	public void testNamedServiceWhenHaveValueReturnNamedService() {
		// arrange
		RestResource rr = new RestResource();
		String nameService = "Testing";
		String expected = "Testing Service";
		String message = "Result should always match value: " + expected;

		// action
		String actual = rr.namedService(nameService);

		// assert
		assertEquals(message, expected, actual);
	}

	@Test
	public void testNamedServiceWhenEmptyValueReturnEmptyNameService() {
		// arrange
		RestResource rr = new RestResource();
		String nameService = "";
		String expected = " Service";
		String message = "Result should always match value: " + expected;

		// action
		String actual = rr.namedService(nameService);

		// assert
		assertEquals(message, expected, actual);
	}

	@Test
	public void testNamedServiceWhenNullValueReturnNullNameService() {
		// arrange
		RestResource rr = new RestResource();
		String nameService = null;
		String expected = "null Service";
		String message = "Result should always match value: " + expected;

		// action
		String actual = rr.namedService(nameService);

		// assert
		assertEquals(message, expected, actual);
	}
}
