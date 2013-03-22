package com.everson.common.enums;

public enum MascotEnum {
	
	AMIJUBI(0, "Amijubi"), FULECO(1, "Fuleco"), ZUZECO(2, "Zuzeco");
	
	MascotEnum(int index, String name) {
		this.index = index;
		this.name = name;
	}
	
	private int index;
	private String name;
	
	public int getIndex() {
		return index;
	}

	public String getName() {
		return name;
	}	
	
}
