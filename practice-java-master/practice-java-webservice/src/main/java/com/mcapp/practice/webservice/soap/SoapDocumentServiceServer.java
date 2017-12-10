package com.mcapp.practice.webservice.soap;

import javax.xml.ws.Endpoint;

public class SoapDocumentServiceServer {
	public static void main(String[] args) {
		SoapDocumentService s = new SoapDocumentServiceImpl();
		Endpoint.publish("http://localhost/ws/soapdocumentservice", s);
	}
}
