package com.mcapp.practice.jms.batch;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class JmsProducer implements Runnable {
	public void run() {
		LocalDateTime lDTNow = LocalDateTime.now();
		DateTimeFormatter dateTimeFt = DateTimeFormatter.ISO_DATE_TIME;

		Connection connection = null;
		Session session = null;
		MessageProducer producer = null;

		try {
			String brokerUrl = "vm://localhost?broker.persistent=false";
			ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(brokerUrl);

			connection = connectionFactory.createConnection();
			connection.start();

			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

			Destination destination = session.createQueue("queue.myqueue");

			producer = session.createProducer(destination);

			String message = dateTimeFt.format(lDTNow) + " - Message from JmsProducerBatch";
			TextMessage textMessage = session.createTextMessage(message);

			producer.send(textMessage);

			System.out.println("Message Sent: " + message);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (producer != null) {
					producer.close();
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
