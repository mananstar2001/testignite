package com.xyz.testignite.pojo;

import java.util.List;

import org.apache.ignite.cache.query.annotations.QuerySqlField;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Target {

	String type;

	@QuerySqlField(index = true)
	String key;

	@QuerySqlField(index = true)
	String displayName;
	List<JsonNode> externalIds;
	JsonNode extensions;
	JsonNode relationships;
	float revisionId;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

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

	public List<JsonNode> getExternalIds() {
		return externalIds;
	}

	public void setExternalIds(List<JsonNode> externalIds) {
		this.externalIds = externalIds;
	}

	public JsonNode getExtensions() {
		return extensions;
	}

	public void setExtensions(JsonNode extensions) {
		this.extensions = extensions;
	}

	public JsonNode getRelationships() {
		return relationships;
	}

	public void setRelationships(JsonNode relationships) {
		this.relationships = relationships;
	}

	public float getRevisionId() {
		return revisionId;
	}

	public void setRevisionId(float revisionId) {
		this.revisionId = revisionId;
	}

	@Override
	public String toString() {
		return "Target [type=" + type + ", key=" + key + ", displayName=" + displayName + ", externalIds=" + externalIds
				+ ", extensions=" + extensions + ", relationships=" + relationships + ", revisionId=" + revisionId
				+ "]";
	}

}
