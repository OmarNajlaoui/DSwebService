package de.tekup.whitetest.Services;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.springframework.stereotype.Service;
import de.tekup.soap.models.whitetest.Exam;
import de.tekup.whitetest.WhiteTestesApplication;
import de.tekup.soap.models.whitetest.ObjectFactory;
import de.tekup.soap.models.whitetest.StudentRequest;
import de.tekup.soap.models.whitetest.WhiteTestResponse;
import de.tekup.soap.models.whitetest.Student;
import de.tekup.soap.models.whitetest.Student.Address;

@Service
public class WhiteTestService {
	
	public  List<Student> students = new ArrayList<Student>();
	public  List<Exam> exams = new ArrayList<Exam>();


	public WhiteTestResponse checkExam(StudentRequest studentRequest) throws DatatypeConfigurationException
	{
		
		Address a1 = new Address();
		a1.setCity("city_1");
		a1.setStreet("street_1");
		a1.setPosteCode("000001");
		
		Address a2 = new Address();
		a2.setCity("city_2");
		a2.setStreet("street_2");
		a2.setPosteCode("000002");
		
		Address a3 = new Address();
		a3.setCity("city_3");
		a3.setStreet("street_3");
		a3.setPosteCode("000003");
		
		Address falseAddress = new Address();
		falseAddress.setCity("false city");
		falseAddress.setStreet("false street");
		falseAddress.setPosteCode("no poste code");
		
		students.add(new Student(1,"student_1",a1));
		students.add(new Student(2,"student_2",a2));
		students.add(new Student(3,"student_3",a3));
		
		exams.add(new Exam("codeA","OCA"));
		exams.add(new Exam("codeP","OCP"));
		
		Student falseStudent = new Student (-1, "false",falseAddress);
		Exam falseExam = new Exam ("-1","false");
		
		WhiteTestResponse response = new ObjectFactory().createWhiteTestResponse();
		
		
		//default response
		response.setExam(falseExam);
		response.setStudent(falseStudent);
		
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
        DatatypeFactory datatypeFactory = DatatypeFactory.newInstance();
        XMLGregorianCalendar now = 
            datatypeFactory.newXMLGregorianCalendar(gregorianCalendar);
		
		for (Student student : students) { 		

	           if (student.getId() == studentRequest.getStudentId())
	           {
	        	   System.out.println("student id : "+student.getId());
	        	   System.out.println("studentRequest id : "+studentRequest.getStudentId());
	        	   System.out.println(student.getId() == studentRequest.getStudentId());
	        	   System.out.println(student.toString());
	        	   response.setStudent(student);
	           }
	      }
		for (Exam exam : exams)
		{
			if (exam.getCode().equals(studentRequest.getExamCode()))
			{
				response.setExam(exam);
				response.setDate(now);
			}
		}

		return response;
	}

}
