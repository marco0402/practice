package com.mcapp.practice.webservice.soap;

import javax.xml.ws.Endpoint;

public class SoapRpcServiceServer {
	public static void main(String[] args) {
		SoapRpcService s = new SoapRpcServiceImpl();
		Endpoint.publish("http://localhost/ws/soaprpcservice", s);
	}
}
