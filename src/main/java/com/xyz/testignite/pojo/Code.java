package com.xyz.testignite.pojo;

public class Code {

	String key;
	String displayName;
	String type;
	String name;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Code [key=" + key + ", displayName=" + displayName + ", type=" + type + ", name=" + name + "]";
	}

}
