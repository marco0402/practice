package com.mcapp.practice.jms.servlet;

import java.io.IOException;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jms-consumer")
public class JmsConsumerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection connection = null;
		Session session = null;
		MessageConsumer consumer = null;

		try {
			InitialContext initialContext = new InitialContext();
			Context envContext = (Context) initialContext.lookup("java:comp/env");

			ConnectionFactory connectionFactory = (ConnectionFactory) envContext.lookup("jms/ConnectionFactory");

			connection = connectionFactory.createConnection();
			connection.start();

			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

			Destination destination = (Destination) envContext.lookup("jms/queue/myqueue");

			consumer = session.createConsumer(destination);

			TextMessage textMessage = (TextMessage) consumer.receive(10000);

			String message = "No Message after waiting for 10 seconds";
			if (textMessage != null) {
				message = textMessage.getText();
			}

			request.setAttribute("result", "Success: " + message);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "Failure");
		} finally {
			try {
				consumer.close();
				session.close();
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("result", "Failure");
			}
		}

		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
}
