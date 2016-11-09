package com.xyz.testignite.pojo;

import java.util.List;

import org.apache.ignite.cache.query.annotations.QuerySqlField;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer {

	JsonNode relation;

	@QuerySqlField(index = true)
	List<Target> targets;
	String firstTarget;
	String type;
	String _id;

	public JsonNode getRelation() {
		return relation;
	}

	public void setRelation(JsonNode relation) {
		this.relation = relation;
	}

	public List<Target> getTargets() {
		return targets;
	}

	public void setTargets(List<Target> targets) {
		this.targets = targets;
	}

	public String getFirstTarget() {
		return firstTarget;
	}

	public void setFirstTarget(String firstTarget) {
		this.firstTarget = firstTarget;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	@Override
	public String toString() {
		return "Customer [relation=" + relation + ", targets=" + targets + ", firstTarget=" + firstTarget + ", type="
				+ type + ", _id=" + _id + "]";
	}

}
