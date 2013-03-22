package com.everson.ejb;

import java.math.BigInteger;
import java.util.logging.Logger;

import javax.ejb.Stateless;

import com.everson.common.enums.MascotEnum;
import com.everson.common.exception.NativeRuntimeException;
import com.everson.common.util.MascotUtil;
import com.everson.common.vo.UrnVO;

@Stateless(name=UrnBeanRemote.NAME)
public class UrnBean implements UrnBeanRemote {
	
	Logger logger = Logger.getAnonymousLogger();
	
	private static UrnVO urnVO = new UrnVO();
	private static Boolean updateON = true;
	private BigInteger onebigInteger = new BigInteger("1");
	
	public void initThreadDB() {
		if (updateON) {
			updateON = false;
			UpdateInner updateInner = new UpdateInner();
			Thread thread = new Thread(updateInner);
			thread.start();
		}
	}
	
	@Override
	public MascotEnum voteMascote(Integer indexMascot) {

		MascotEnum mascotEnum = MascotUtil.mascotBuilder(indexMascot);
		
		if (mascotEnum == null) {
			throw new NativeRuntimeException("Mascote não encontrado");
		}
		
		switch (mascotEnum) {
			case AMIJUBI:
				urnVO.setAmijubi(urnVO.getAmijubi().add(onebigInteger));
				break;
			case FULECO:
				urnVO.setFuleco(urnVO.getFuleco().add(onebigInteger));
				break;
			case ZUZECO:
				urnVO.setZuzeco(urnVO.getZuzeco().add(onebigInteger));
				break;				

		}
		
		initThreadDB();
		return mascotEnum;
	}

	@Override
	public UrnVO urnVotes() {
		return urnVO;
	}

	class UpdateInner extends Thread {
		
		public void run() {
			try {
				UpdateInner.sleep(1000 * 10);
				updateVotes();
				updateON = true;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		public Boolean updateVotes() {
			
			logger.info(":: Atualizando BD");
			logger.info(MascotEnum.AMIJUBI + ": " + urnVO.getAmijubi()
					+ " - " + MascotEnum.FULECO + ": " + urnVO.getFuleco()
					+ " - " + MascotEnum.ZUZECO + ": " + urnVO.getZuzeco());
			
			
			return Boolean.FALSE;
		}

	}

}
