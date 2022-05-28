package de.tekup.whitetest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;

import org.springframework.xml.xsd.XsdSchema;

import de.tekup.whitetest.EndPoint.*;

@EnableWs
@Configuration
public class ExamsListServiceConfiguration {

	@Bean(name="Exams")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema schema)
	{
		DefaultWsdl11Definition defaultWsdl11Definition = new DefaultWsdl11Definition();
		defaultWsdl11Definition.setPortTypeName("ExamsList");
		defaultWsdl11Definition.setLocationUri("/ws/");
		
		defaultWsdl11Definition.setTargetNamespace(ListeExamsEndPoint.nameSpace);
		defaultWsdl11Definition.setSchema(schema);
		return defaultWsdl11Definition;
	}

}