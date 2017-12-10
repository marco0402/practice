package com.mcapp.practice.jms.batch;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.doNothing;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.whenNew;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
public class JmsBatchTest {
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
	@PrepareForTest({ JmsBatch.class, Thread.class })
	public void testMainWhenAllCasesExecuteStart() {
		// arrange
		String[] args = null;

		JmsConsumer mockJmsConsumer = mock(JmsConsumer.class);
		JmsProducer mockJmsProducer = mock(JmsProducer.class);
		Thread mockJmsConsumerThread = mock(Thread.class);
		Thread mockJmsProducerThread = mock(Thread.class);

		try {
			whenNew(JmsConsumer.class).withNoArguments().thenReturn(mockJmsConsumer);
		} catch (Exception e) {
			fail("Exception should not throw");
		}
		try {
			whenNew(JmsProducer.class).withNoArguments().thenReturn(mockJmsProducer);
		} catch (Exception e) {
			fail("Exception should not throw");
		}
		try {
			whenNew(Thread.class).withArguments(mockJmsConsumer).thenReturn(mockJmsConsumerThread);
		} catch (Exception e) {
			fail("Exception should not throw");
		}
		try {
			whenNew(Thread.class).withArguments(mockJmsProducer).thenReturn(mockJmsProducerThread);
		} catch (Exception e) {
			fail("Exception should not throw");
		}

		doNothing().when(mockJmsConsumerThread).start();
		mockStatic(Thread.class);
		doNothing().when(mockJmsProducerThread).start();

		// action
		try {
			JmsBatch.main(args);
		} catch (Exception e) {
			fail("Exception should not throw");
		}

		// assert
		verify(mockJmsConsumerThread, times(1)).start();
		verify(mockJmsProducerThread, times(1)).start();
	}
}
