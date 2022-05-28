package de.tekup.whitetest.Services;

import org.springframework.stereotype.Service;
import de.tekup.soap.models.whitetest.Exam;
import de.tekup.soap.models.whitetest.ExamsRequest;
import de.tekup.soap.models.whitetest.ExamsResponse;
import de.tekup.soap.models.whitetest.ObjectFactory;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListExamService {
	public  List<Exam> AvailableExams = new ArrayList<Exam>();
	
	public ExamsResponse examsList(ExamsRequest examRequest)
	{
		AvailableExams.add(new Exam("codeA","OCA"));
		AvailableExams.add(new Exam("codeB","OCP"));
		ExamsResponse response = new ObjectFactory().createExamsResponse();
		if (examRequest.isListExams())
		{
			System.out.println("********************************************");

			response.setExam(AvailableExams);
		}
		return response;
	}
}
