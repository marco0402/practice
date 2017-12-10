package com.mcapp.practice.webservice.soap;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class SoapDocumentServiceClient {
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://localhost/ws/soapdocumentservice?wsdl");
		QName qName = new QName("http://soap.webservice.practice.mcapp.com/",
				"SoapDocumentServiceImplService");
		Service service = Service.create(url, qName);
		SoapDocumentService s = service.getPort(SoapDocumentService.class);

		System.out.println(s.getServiceName());
	}
}
