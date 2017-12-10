package com.mcapp.practice.jms.batch;

public class JmsBatch {
	public static void main(String[] args) throws Exception {
		JmsConsumer jmsConsumer = new JmsConsumer();
		JmsProducer jmsProducer = new JmsProducer();

		Thread jmsConsumerThread = new Thread(jmsConsumer);
		Thread jmsProducerThread = new Thread(jmsProducer);

		jmsConsumerThread.start();
		Thread.sleep(10000);
		jmsProducerThread.start();
	}
}
