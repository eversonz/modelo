package com.everson.common.util;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ArithmeticUtil {

	public static BigDecimal percent(BigInteger value, BigInteger total) {
		
		if (total == null || total.intValue() < 1) {
			return new BigDecimal("0");
		}
		if (value == null || value.intValue() < 1) {
			value = new BigInteger("0");
		}
		
		BigDecimal porc = new BigDecimal("100");
		return new BigDecimal(value).multiply(porc).divide(new BigDecimal(total), 2, BigDecimal.ROUND_HALF_EVEN);
	}
	
}
