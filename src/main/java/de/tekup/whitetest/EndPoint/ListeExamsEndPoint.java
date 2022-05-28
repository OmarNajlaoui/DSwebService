package de.tekup.whitetest.EndPoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import de.tekup.whitetest.Services.*;
import de.tekup.soap.models.whitetest.ExamsRequest;
import de.tekup.soap.models.whitetest.ExamsResponse;




@Endpoint
public class ListeExamsEndPoint {

	public static final String nameSpace = "http://www.tekup.de/soap/models/whitetest";
	
	@Autowired
	private ListExamService service;
	
	@PayloadRoot(namespace = nameSpace, localPart = "ExamsRequest")
	@ResponsePayload
	public ExamsResponse getExams(@RequestPayload ExamsRequest examsRequest)
	{
		return service.examsList(examsRequest);
	}

}
