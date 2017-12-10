package com.mcapp.practice.webservice.soap;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.times;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;

import javax.xml.ws.Endpoint;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
public class SoapDocumentServiceServerTest {
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
	@PrepareForTest({ SoapDocumentServiceServer.class, Endpoint.class })
	public void testMainWhenAllCasesExecutePublish() {
		// arrange
		String[] args = null;

		SoapDocumentServiceImpl mockSoapDocumentServiceImpl = mock(SoapDocumentServiceImpl.class);

		try {
			whenNew(SoapDocumentServiceImpl.class).withNoArguments().thenReturn(mockSoapDocumentServiceImpl);
		} catch (Exception e) {
			fail("Exception should not throw");
		}
		mockStatic(Endpoint.class);
		when(Endpoint.publish("http://localhost/ws/soapdocumentservice", mockSoapDocumentServiceImpl)).thenReturn(null);

		// action
		SoapDocumentServiceServer.main(args);

		// assert
		verifyStatic(times(1));
		Endpoint.publish("http://localhost/ws/soapdocumentservice", mockSoapDocumentServiceImpl);
	}
}
