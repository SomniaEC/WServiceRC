package com.sommnia.registroCivil.webService.client;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

import org.w3c.dom.Node;


/**
 * 
 * @author mtrujillo
 * 
 */
public class Client {
	public static void main(String[] args) {
		try {
			// Create SOAP Connection
			SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
			SOAPConnection soapConnection = soapConnectionFactory.createConnection();
			
			String cedula = System.console().readLine("Ingrese la cedula: ", new Object[0]);
			String codigoDactilar = System.console().readLine("Ingrese el codigo dactilar: ", new Object[0]);
			
			// Send SOAP Message to SOAP Server
			String url = "http://webservice01.registrocivil.gob.ec:8080/WEBRCDatosIdentidad/WSRegistroCivilConsulta?wsdl";
			SOAPMessage soapResponse = soapConnection.call(Client.createSOAPRequest(cedula, codigoDactilar), url);
			
			// Parse response
			Cedula response = Client.parseSoap(soapResponse);
			
			System.out.println();
			System.out.println("Respuesta: ");
			System.out.println("Cedula: " + (response.getCedula() != null ? response.getCedula() : "desconocido"));
			System.out.println("Nombre: " + (response.getNombre() != null ? response.getNombre() : "desconocido"));
			System.out.println("Estado Civil: " + (response.getEstadoCivil() != null ? response.getEstadoCivil() : "desconocido"));
			
			soapConnection.close();
		} catch (UnsupportedOperationException e) {
			e.printStackTrace();
		} catch (SOAPException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static SOAPMessage createSOAPRequest(String cedula, String codigoDactilar) throws Exception {
		MessageFactory messageFactory = MessageFactory.newInstance();
		SOAPMessage soapMessage = messageFactory.createMessage();
		SOAPPart soapPart = soapMessage.getSOAPPart();
		
		String serverURI = "http://www.registrocivil.gob.ec";
		
		// SOAP Envelope
		SOAPEnvelope envelope = soapPart.getEnvelope();
		envelope.addNamespaceDeclaration("reg", serverURI);
		
		/*
        Constructed SOAP Request Message:
        <SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/" xmlns:reg="http://www.registrocivil.gob.ec">
            <SOAP-ENV:Header/>
            <SOAP-ENV:Body>
                <reg:BusquedaPorCedula>
                    <Cedula>1022334455</Cedula>
                    <IndividualDactilar>V1234V</IndividualDactilar>
                    <Usuario>123</Usuario>
                    <Contrasenia>123</Contrasenia>
                </example:VerifyEmail>
            </SOAP-ENV:Body>
        </SOAP-ENV:Envelope>
         */
		
		SOAPBody soapBody = envelope.getBody();
		
		SOAPElement soapBodyElem = soapBody.addChildElement("BusquedaPorCedula", "reg");
		SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("Cedula");
		soapBodyElem1.addTextNode(cedula);
		SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("IndividualDactilar");
		soapBodyElem2.addTextNode(codigoDactilar);
		SOAPElement soapBodyElem3 = soapBodyElem.addChildElement("Usuario");
		soapBodyElem3.addTextNode("proactiva2");
		SOAPElement soapBodyElem4 = soapBodyElem.addChildElement("Contrasenia");
		soapBodyElem4.addTextNode("AcT4%Wld");
		
		MimeHeaders headers = soapMessage.getMimeHeaders();
		headers.addHeader("SOAPAction", String.valueOf(serverURI) + "VerifyEmail");
		soapMessage.saveChanges();
		
		return soapMessage;
	}
	
	private static Cedula parseSoap(SOAPMessage soapResponse) {
		try {
			JAXBContext jc = JAXBContext.newInstance(Cedula.class);
			Unmarshaller um = jc.createUnmarshaller();
			Node node = soapResponse.getSOAPBody().extractContentAsDocument().getFirstChild().getFirstChild();
			Cedula output = (Cedula) um.unmarshal(node);
			return output;
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (SOAPException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
