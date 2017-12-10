package com.mcapp.practice.webservice.soap;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SoapDocumentServiceImplTest {
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
		SoapDocumentServiceImpl sdsi = new SoapDocumentServiceImpl();
		String expected = "Soap Document Service";
		String message = "Result should always match value: " + expected;

		// action
		String actual = sdsi.getServiceName();

		// assert
		assertEquals(message, expected, actual);
	}
}
