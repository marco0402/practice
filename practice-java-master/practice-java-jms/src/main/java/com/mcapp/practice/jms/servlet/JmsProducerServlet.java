package com.mcapp.practice.jms.servlet;

import java.io.IOException;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jms-producer")
public class JmsProducerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection connection = null;
		Session session = null;
		MessageProducer producer = null;

		try {
			String requestMessage = request.getParameter("requestMessage");

			InitialContext initialContext = new InitialContext();
			Context envContext = (Context) initialContext.lookup("java:comp/env");

			ConnectionFactory connectionFactory = (ConnectionFactory) envContext.lookup("jms/ConnectionFactory");

			connection = connectionFactory.createConnection();
			connection.start();

			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

			Destination destination = (Destination) envContext.lookup("jms/queue/myqueue");

			producer = session.createProducer(destination);

			TextMessage testMessage = session.createTextMessage();
			testMessage.setText(requestMessage);

			producer.send(testMessage);

			request.setAttribute("result", "Success: " + requestMessage);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "Failure");
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
				request.setAttribute("result", "Failure");
			}
		}

		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
}
