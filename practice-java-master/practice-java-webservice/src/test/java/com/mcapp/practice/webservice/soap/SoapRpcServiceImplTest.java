package com.mcapp.practice.webservice.soap;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SoapRpcServiceImplTest {
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
	public void testGetServiceNameWhenAllCasesReturnStaticValue() {
		// arrange
		SoapRpcServiceImpl srsi = new SoapRpcServiceImpl();
		String expected = "Soap RPC Service";
		String message = "Result should always match value: " + expected;

		// action
		String actual = srsi.getServiceName();

		// assert
		assertEquals(message, expected, actual);
	}
}
