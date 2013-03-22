package com.everson.ejb.ws;


import java.rmi.Remote;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style=Style.RPC)
public interface UrnWS extends Remote{
	
	public static final String NAME = "ejb/UrnWS";
	
	public Boolean voteMascote (Integer indexMascot);
	
}
