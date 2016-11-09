package com.xyz.testignite.pojo;

import java.util.List;

public class OrganizationDataNode {

	List<Organization> data;
	boolean hasMoreRecords;

	public List<Organization> getData() {
		return data;
	}

	public void setData(List<Organization> data) {
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
