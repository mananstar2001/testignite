package com.xyz.testignite.pojo;

import org.apache.ignite.cache.query.annotations.QuerySqlField;

public class NormalizedAmount {
    
    @QuerySqlField(index=true)
	Code code;
	@QuerySqlField(index=true)
	float rate;
	@QuerySqlField(index=true)
	float amount;
	String convertedOn;

	public Code getCode() {
		return code;
	}

	public void setCode(Code code) {
		this.code = code;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getConvertedOn() {
		return convertedOn;
	}

	public void setConvertedOn(String convertedOn) {
		this.convertedOn = convertedOn;
	}

	@Override
	public String toString() {
		return "NormalizedAmount [code=" + code + ", rate=" + rate + ", amount=" + amount + ", convertedOn="
				+ convertedOn + "]";
	}

}
