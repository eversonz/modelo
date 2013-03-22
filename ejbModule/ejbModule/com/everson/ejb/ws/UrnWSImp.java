package com.everson.ejb.ws;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import com.everson.ejb.UrnBeanRemote;

@Stateless(name=UrnWS.NAME)
@WebService(serviceName="UrnWS",
			portName="UrnWSPort",
			endpointInterface="com.everson.ejb.ws.UrnWS",
			targetNamespace = "http://jaxws.samples.geronimo.apache.org")
public class UrnWSImp implements UrnWS {

	@EJB
	UrnBeanRemote urnBean;
	
	public Boolean voteMascote(Integer indexMascot) {

		if (urnBean.voteMascote(indexMascot) != null) {
			return true;
		}
		
		return false;
	}
	
	
	
}
