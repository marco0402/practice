package com.mcapp.practice.webservice.soap;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class SoapRpcServiceClient {
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://localhost/ws/soaprpcservice?wsdl");
		QName qName = new QName("http://soap.webservice.practice.mcapp.com/", "SoapRpcServiceImplService");
		Service service = Service.create(url, qName);
		SoapRpcService s = service.getPort(SoapRpcService.class);

		System.out.println(s.getServiceName());
	}
}
