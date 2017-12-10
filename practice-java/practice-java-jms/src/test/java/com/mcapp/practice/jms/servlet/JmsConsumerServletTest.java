package com.mcapp.practice.jms.servlet;

import static org.junit.Assert.fail;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.doNothing;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
public class JmsConsumerServletTest {
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
	@PrepareForTest({ JmsConsumerServlet.class })
	public void testDoPostWhenMessagePresentAssignMessageToResult() {
		// arrange
		JmsConsumerServlet jmsConsumerServlet = new JmsConsumerServlet();

		HttpServletRequest mockRequest = mock(HttpServletRequest.class);
		HttpServletResponse mockResponse = mock(HttpServletResponse.class);
		InitialContext mockInitialContext = mock(InitialContext.class);
		Context mockContext = mock(Context.class);
		ConnectionFactory mockConnectionFactory = mock(ConnectionFactory.class);
		Connection mockConnection = mock(Connection.class);
		Session mockSession = mock(Session.class);
		Destination mockDestination = mock(Destination.class);
		MessageConsumer mockConsumer = mock(MessageConsumer.class);
		TextMessage mockTextMessage = mock(TextMessage.class);
		RequestDispatcher mockRequestDispatcher = mock(RequestDispatcher.class);

		try {
			whenNew(InitialContext.class).withNoArguments().thenReturn(mockInitialContext);
			when(mockInitialContext.lookup(anyString())).thenReturn(mockContext);
			when(mockContext.lookup("jms/ConnectionFactory")).thenReturn(mockConnectionFactory);
			when(mockConnectionFactory.createConnection()).thenReturn(mockConnection);
			doNothing().when(mockConnection).start();
			when(mockConnection.createSession(false, Session.AUTO_ACKNOWLEDGE)).thenReturn(mockSession);
			when(mockContext.lookup("jms/queue/myqueue")).thenReturn(mockDestination);
			when(mockSession.createConsumer(mockDestination)).thenReturn(mockConsumer);
			when(mockConsumer.receive(10000)).thenReturn(mockTextMessage);
			when(mockTextMessage.getText()).thenReturn("Testing Consumer Message");
			doNothing().when(mockRequest).setAttribute("result", "Success: Testing Consumer Message");
			when(mockRequest.getRequestDispatcher(anyString())).thenReturn(mockRequestDispatcher);
			doNothing().when(mockRequestDispatcher).forward(mockRequest, mockResponse);
		} catch (Exception e) {
			fail("Exception should not throw");
		}

		// action
		try {
			jmsConsumerServlet.doPost(mockRequest, mockResponse);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception should not throw");
		}

		// assert
		verify(mockRequest, times(1)).setAttribute("result", "Success: Testing Consumer Message");
	}

	@Test
	@PrepareForTest({ JmsConsumerServlet.class })
	public void testDoPostWhenMessageAbsentAssignDefaultMessageToResult() {
		// arrange
		JmsConsumerServlet jmsConsumerServlet = new JmsConsumerServlet();

		HttpServletRequest mockRequest = mock(HttpServletRequest.class);
		HttpServletResponse mockResponse = mock(HttpServletResponse.class);
		InitialContext mockInitialContext = mock(InitialContext.class);
		Context mockContext = mock(Context.class);
		ConnectionFactory mockConnectionFactory = mock(ConnectionFactory.class);
		Connection mockConnection = mock(Connection.class);
		Session mockSession = mock(Session.class);
		Destination mockDestination = mock(Destination.class);
		MessageConsumer mockConsumer = mock(MessageConsumer.class);
		RequestDispatcher mockRequestDispatcher = mock(RequestDispatcher.class);

		try {
			whenNew(InitialContext.class).withNoArguments().thenReturn(mockInitialContext);
			when(mockInitialContext.lookup(anyString())).thenReturn(mockContext);
			when(mockContext.lookup("jms/ConnectionFactory")).thenReturn(mockConnectionFactory);
			when(mockConnectionFactory.createConnection()).thenReturn(mockConnection);
			doNothing().when(mockConnection).start();
			when(mockConnection.createSession(false, Session.AUTO_ACKNOWLEDGE)).thenReturn(mockSession);
			when(mockContext.lookup("jms/queue/myqueue")).thenReturn(mockDestination);
			when(mockSession.createConsumer(mockDestination)).thenReturn(mockConsumer);
			when(mockConsumer.receive(10000)).thenReturn(null);
			doNothing().when(mockRequest).setAttribute("result", "Success: No Message after waiting for 10 seconds");
			when(mockRequest.getRequestDispatcher(anyString())).thenReturn(mockRequestDispatcher);
			doNothing().when(mockRequestDispatcher).forward(mockRequest, mockResponse);
		} catch (Exception e) {
			fail("Exception should not throw");
		}

		// action
		try {
			jmsConsumerServlet.doPost(mockRequest, mockResponse);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception should not throw");
		}

		// assert
		verify(mockRequest, times(1)).setAttribute("result", "Success: No Message after waiting for 10 seconds");
	}
}
