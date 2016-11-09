package com.xyz.testignite.pojo;

import org.apache.ignite.cache.query.annotations.QuerySqlField;

public class Amount {

    @QuerySqlField(index=true)
	Code code;
    
    @QuerySqlField(index=true)
	String type;
    
	@QuerySqlField(index=true)
	float amount;
	NormalizedAmount normalizedAmount;

	public Code getCode() {
		return code;
	}

	public void setCode(Code code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public NormalizedAmount getNormalizedAmount() {
		return normalizedAmount;
	}

	public void setNormalizedAmount(NormalizedAmount normalizedAmount) {
		this.normalizedAmount = normalizedAmount;
	}

	@Override
	public String toString() {
		return "Amount [code=" + code + ", type=" + type + ", amount=" + amount + ", normalizedAmount="
				+ normalizedAmount + "]";
	}

}
