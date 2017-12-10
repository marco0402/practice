package com.mcapp.practice.webservice.soap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.isNotNull;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
public class SoapRpcServiceClientTest {
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
	@PrepareForTest({ SoapRpcServiceClient.class, Service.class })
	public void testMainWhenAllCasesReturnStaticValue() {
		// arrange
		String[] args = null;
		String expected = "Testing Service\n";
		String message = "Result should always match value: " + expected;

		URL mockUrl = mock(URL.class);
		QName mockQName = mock(QName.class);
		Service mockService = mock(Service.class);
		SoapRpcService mockSoapRpcService = mock(SoapRpcService.class);

		try {
			whenNew(URL.class).withArguments(isNotNull(String.class)).thenReturn(mockUrl);
		} catch (Exception e) {
			fail("Exception should not throw");
		}
		try {
			whenNew(QName.class).withArguments(isNotNull(String.class), isNotNull(String.class)).thenReturn(mockQName);
		} catch (Exception e1) {
			fail("Exception should not throw");
		}
		mockStatic(Service.class);
		when(Service.create(mockUrl, mockQName)).thenReturn(mockService);
		when(mockService.getPort(SoapRpcService.class)).thenReturn(mockSoapRpcService);
		when(mockSoapRpcService.getServiceName()).thenReturn("Testing Service");

		// action
		try {
			SoapRpcServiceClient.main(args);
		} catch (Exception e) {
			fail("Exception should not throw");
		}
		String actual = systemOutRule.getLogWithNormalizedLineSeparator();

		// assert
		assertEquals(message, expected, actual);
	}
}
