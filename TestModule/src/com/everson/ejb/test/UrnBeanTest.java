package com.everson.ejb.test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.logging.Logger;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Test;

import com.everson.common.enums.MascotEnum;
import com.everson.common.util.ArithmeticUtil;
import com.everson.common.vo.UrnVO;
import com.everson.ejb.UrnBeanRemote;
import com.everson.ejb.ws.UrnWS;


public class UrnBeanTest {

	private UrnBeanRemote urnBeanRemote;
	Logger logger = Logger.getLogger("test");
	
	
	public UrnBeanTest() {
		
		try {
			String ejbName = UrnBeanRemote.NAME;
			InitialContext ctx = new InitialContext();
			urnBeanRemote = (UrnBeanRemote) ctx.lookup("earModule/"  + ejbName + "/remote");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void voteMascoteTest()   {

		urnBeanRemote.voteMascote(MascotEnum.AMIJUBI.getIndex());
		urnBeanRemote.voteMascote(MascotEnum.AMIJUBI.getIndex());		
		urnBeanRemote.voteMascote(MascotEnum.FULECO.getIndex());
		
//		for(int i = 0; 100 > i; i++) {
//			urnBeanRemote.voteMascote(MascotEnum.AMIJUBI.getIndex());
//			urnBeanRemote.voteMascote(MascotEnum.FULECO.getIndex());
//			urnBeanRemote.voteMascote(MascotEnum.ZUZECO.getIndex());
//		}

	}
	
	@Test
	public void urnVotes() {
		UrnVO urnVO = urnBeanRemote.urnVotes();
		BigInteger total = urnVO.getAmijubi().add(urnVO.getFuleco()).add(urnVO.getZuzeco());
		
		logger.info(MascotEnum.AMIJUBI + ": " + ArithmeticUtil.percent(urnVO.getAmijubi(), total).toString() + "%");
		logger.info(MascotEnum.FULECO + ": " + ArithmeticUtil.percent(urnVO.getFuleco(), total).toString() + "%");
		logger.info(MascotEnum.ZUZECO + ": " + ArithmeticUtil.percent(urnVO.getZuzeco(), total).toString() + "%");	
	}
	
}
