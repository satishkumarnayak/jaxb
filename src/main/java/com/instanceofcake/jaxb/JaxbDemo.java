package com.instanceofcake.jaxb;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.bharatthippireddy.patient.Patient;

public class JaxbDemo {

	public static void main(String[] args) throws JAXBException {

		JAXBContext context = JAXBContext.newInstance(Patient.class);
		Marshaller marshaller = context.createMarshaller();

		Patient patient = new Patient();
		patient.setId(123);
		patient.setName("John");

		StringWriter stringWriter = new StringWriter();
		marshaller.marshal(patient, stringWriter);

		System.out.println(stringWriter.toString());

		Unmarshaller unmarshaller = context.createUnmarshaller();
		Patient patientResult = (Patient) unmarshaller.unmarshal(new StringReader(stringWriter.toString()));
		System.out.println(patientResult.getName());

	}

}
