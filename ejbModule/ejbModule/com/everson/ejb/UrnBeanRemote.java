package com.everson.ejb;

import javax.ejb.Remote;

import com.everson.common.enums.MascotEnum;
import com.everson.common.vo.UrnVO;

@Remote
public interface UrnBeanRemote {
	
	public static final String NAME = "ejb/UrnBean";

	public MascotEnum voteMascote (Integer indexMascot);
	
	public UrnVO urnVotes();
	
}
