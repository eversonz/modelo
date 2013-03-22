package com.everson.contole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceFactory;

import com.everson.common.enums.MascotEnum;
import com.everson.common.util.MascotUtil;
import com.everson.ejb.ws.UrnWS;

public class Vote {
	private UrnWS urnWS;
    private BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
	
	public void loadClass() {
		try {
			
			String serverPort = "http://localhost:8080";
			System.out.println("Ïnforme o servidor e porta no modelo: " + serverPort + " ou ENTER para usar o modelo");
			
			String serverPortTmp = keyboard();
			
			if (serverPortTmp.length() > 0) {
				serverPort = serverPortTmp;
			}
			
			URL url = new URL(serverPort + "/ejbModule/UrnWS/UrnWSImp?wsdl");
			QName qname = new QName("http://jaxws.samples.geronimo.apache.org", "UrnWS");
			
			ServiceFactory factory = ServiceFactory.newInstance();
			Service service = factory.createService(url, qname);
			
			urnWS = (UrnWS) service.getPort(UrnWS.class);
			
			System.out.println(urnWS);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}	
	
	public void mascot() {		
		System.out.println("\n\nEscolha o mascote pelo numero:");
		System.out.println("0 - " + MascotEnum.AMIJUBI);
		System.out.println("1 - " + MascotEnum.FULECO);
		System.out.println("2 - " + MascotEnum.ZUZECO);
		System.out.println("99 - Fechar");	
	}
	
	public void input() {

		try {
	    	int indexMascot = Integer.valueOf(keyboard().trim());		   
	    	
	    	if (indexMascot == 99) {
	    		System.exit(0);
	    	}
	    	
	    	urnWS.voteMascote(Integer.valueOf(indexMascot));
	    	
	    	MascotEnum mascotEnum = MascotUtil.mascotBuilder(Integer.valueOf(indexMascot));
	    	
	    	System.out.println("::	Obrigado por votar no " + mascotEnum.getName());
		} catch (NumberFormatException e) {
			System.out.println("::	Voto nulo");
		} 

	}
	
	private String keyboard() {
		String value = "";
		try {
			value = bufferRead.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}		  
		return value;
	}
	
}
