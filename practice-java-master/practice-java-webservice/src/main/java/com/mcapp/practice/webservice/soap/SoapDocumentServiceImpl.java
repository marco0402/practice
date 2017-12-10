package com.mcapp.practice.webservice.soap;

import javax.jws.WebService;

@WebService(endpointInterface = "com.mcapp.practice.webservice.soap.SoapDocumentService")
public class SoapDocumentServiceImpl implements SoapDocumentService {
	@Override
	public String getServiceName() {
		return "Soap Document Service";
	}
}
