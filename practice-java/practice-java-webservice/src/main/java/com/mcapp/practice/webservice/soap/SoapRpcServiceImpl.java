package com.mcapp.practice.webservice.soap;

import javax.jws.WebService;

@WebService(endpointInterface = "com.mcapp.practice.webservice.soap.SoapRpcService")
public class SoapRpcServiceImpl implements SoapRpcService {
	@Override
	public String getServiceName() {
		return "Soap RPC Service";
	}
}
