package com.mcapp.practice.jms.batch;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class JmsConsumer implements Runnable {
	public void run() {
		Connection connection = null;
		Session session = null;
		MessageConsumer consumer = null;

		try {
			String brokerUrl = "vm://localhost?broker.persistent=false";
			ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(brokerUrl);

			connection = connectionFactory.createConnection();
			connection.start();

			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

			Destination destination = session.createQueue("queue.myqueue");

			consumer = session.createConsumer(destination);

			TextMessage textMessage = (TextMessage) consumer.receive();
			String message = textMessage.getText();

			System.out.println("Message Received: " + message);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (consumer != null) {
					consumer.close();
				}
				if (session != null) {
					session.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
