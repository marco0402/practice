package com.mcapp.practice.jms.batch;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.anyString;
import static org.powermock.api.mockito.PowerMockito.doNothing;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;

import javax.jms.Connection;
import javax.jms.MessageConsumer;
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
public class JmsConsumerTest {
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
	@PrepareForTest({ JmsConsumer.class })
	public void testRunWhenAllCasesReturnStaticValue() {
		// arrange
		JmsConsumer jmsConsumer = new JmsConsumer();
		String expected = "Message Received: Testing Consumer Message\n";
		String message = "Result should always match value: " + expected;

		ActiveMQConnectionFactory mockActiveMQConnectionFactory = mock(ActiveMQConnectionFactory.class);
		Connection mockConnection = mock(Connection.class);
		Session mockSession = mock(Session.class);
		Queue mockQueue = mock(Queue.class);
		MessageConsumer mockConsumer = mock(MessageConsumer.class);
		TextMessage mockTextMessage = mock(TextMessage.class);

		try {
			whenNew(ActiveMQConnectionFactory.class).withArguments(anyString())
					.thenReturn(mockActiveMQConnectionFactory);
			when(mockActiveMQConnectionFactory.createConnection()).thenReturn(mockConnection);
			doNothing().when(mockConnection).start();
			when(mockConnection.createSession(false, Session.AUTO_ACKNOWLEDGE)).thenReturn(mockSession);
			when(mockSession.createQueue("queue.myqueue")).thenReturn(mockQueue);
			when(mockSession.createConsumer(mockQueue)).thenReturn(mockConsumer);
			when(mockConsumer.receive()).thenReturn(mockTextMessage);
			when(mockTextMessage.getText()).thenReturn("Testing Consumer Message");
		} catch (Exception e) {
			fail("Exception should not throw");
		}

		// action
		jmsConsumer.run();
		String actual = systemOutRule.getLogWithNormalizedLineSeparator();

		// assert
		assertEquals(message, expected, actual);
	}
}
