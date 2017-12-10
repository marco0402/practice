package com.mcapp.practice.jms.batch;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.anyString;
import static org.powermock.api.mockito.PowerMockito.doNothing;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;

import java.util.regex.Pattern;

import javax.jms.Connection;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
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
public class JmsProducerTest {
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
	@PrepareForTest({ JmsProducer.class })
	public void testRunWhenAllCasesReturnStaticValue() {
		// arrange
		JmsProducer jmsProducer = new JmsProducer();
		String expected = "Message Sent: .* - Message from JmsProducerBatch\n";
		String message = "Result should always match value: " + expected;

		ActiveMQConnectionFactory mockActiveMQConnectionFactory = mock(ActiveMQConnectionFactory.class);
		Connection mockConnection = mock(Connection.class);
		Session mockSession = mock(Session.class);
		Queue mockQueue = mock(Queue.class);
		MessageProducer mockProducer = mock(MessageProducer.class);
		TextMessage mockTextMessage = mock(TextMessage.class);

		try {
			whenNew(ActiveMQConnectionFactory.class).withArguments(anyString())
					.thenReturn(mockActiveMQConnectionFactory);
			when(mockActiveMQConnectionFactory.createConnection()).thenReturn(mockConnection);
			doNothing().when(mockConnection).start();
			when(mockConnection.createSession(false, Session.AUTO_ACKNOWLEDGE)).thenReturn(mockSession);
			when(mockSession.createQueue("queue.myqueue")).thenReturn(mockQueue);
			when(mockSession.createProducer(mockQueue)).thenReturn(mockProducer);
			when(mockSession.createTextMessage(anyString())).thenReturn(mockTextMessage);
			doNothing().when(mockConnection).start();
		} catch (Exception e) {
			fail("Exception should not throw");
		}

		// action
		jmsProducer.run();
		String actual = systemOutRule.getLogWithNormalizedLineSeparator();

		// assert
		assertTrue(message, Pattern.matches(expected, actual));
	}
}
