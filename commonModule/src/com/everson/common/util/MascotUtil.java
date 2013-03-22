package com.everson.common.util;

import com.everson.common.enums.MascotEnum;

public abstract class MascotUtil {
	
	private MascotUtil() {
		
	}
		
	public static MascotEnum mascotBuilder(Integer index) {
		
		for (int i = 0; MascotEnum.values().length > i; i ++){
			
			if (MascotEnum.values()[i].getIndex() == index) {
				return MascotEnum.values()[i];
			}
		}
		
		return null;
	}
	
}
