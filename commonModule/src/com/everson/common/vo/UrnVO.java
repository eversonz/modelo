package com.everson.common.vo;

import java.io.Serializable;
import java.math.BigInteger;

public class UrnVO implements Serializable{

	private static final long serialVersionUID = 2981333880247104643L;

	private BigInteger amijubi = new BigInteger("0");
	private BigInteger fuleco = new BigInteger("0");
	private BigInteger zuzeco = new BigInteger("0");
	
	public BigInteger getAmijubi() {
		return amijubi;
	}
	public void setAmijubi(BigInteger amijubi) {
		this.amijubi = amijubi;
	}
	public BigInteger getFuleco() {
		return fuleco;
	}
	public void setFuleco(BigInteger fuleco) {
		this.fuleco = fuleco;
	}
	public BigInteger getZuzeco() {
		return zuzeco;
	}
	public void setZuzeco(BigInteger zuzeco) {
		this.zuzeco = zuzeco;
	}
	
	
	
}
