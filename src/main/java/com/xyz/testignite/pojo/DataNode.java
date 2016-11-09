package com.xyz.testignite.pojo;

import java.util.List;

public class DataNode {

	List<Offer> data;
	boolean hasMoreRecords;

	public List<Offer> getData() {
		return data;
	}

	public void setData(List<Offer> data) {
		this.data = data;
	}

	public boolean isHasMoreRecords() {
		return hasMoreRecords;
	}

	public void setHasMoreRecords(boolean hasMoreRecords) {
		this.hasMoreRecords = hasMoreRecords;
	}

	@Override
	public String toString() {
		return "DataNode [data=" + data + ", hasMoreRecords=" + hasMoreRecords + "]";
	}

}
