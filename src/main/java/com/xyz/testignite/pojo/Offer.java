package com.xyz.testignite.pojo;

import java.util.List;

import org.apache.ignite.cache.query.annotations.QuerySqlField;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Offer {

    @QuerySqlField(index=true)
	String _id;
    
	Amount amount;
	String description;
	
	@QuerySqlField(index=true)
	String displayName;
	List<JsonNode> dq;
	String endDate;
	JsonNode extensions;
	List<JsonNode> externalIds;
	
	@QuerySqlField(index=true)
	boolean isApproved;
	boolean isExcluded;
	List<JsonNode> keywords;
	JsonNode product;

	@QuerySqlField(index = true)
	Relationships relationships;
	boolean requiresApproval;
	JsonNode resellerAmount;
	JsonNode resellerTargetAmount;
	String startDate;
	JsonNode systemProperties;
	List<String> tags;
	JsonNode targetAmount;
	String targetDate;
	
	@QuerySqlField(index=true)
	String type;
	JsonNode upsellAmount;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public Amount getAmount() {
		return amount;
	}

	public void setAmount(Amount amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public List<JsonNode> getDq() {
		return dq;
	}

	public void setDq(List<JsonNode> dq) {
		this.dq = dq;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public JsonNode getExtensions() {
		return extensions;
	}

	public void setExtensions(JsonNode extensions) {
		this.extensions = extensions;
	}

	public List<JsonNode> getExternalIds() {
		return externalIds;
	}

	public void setExternalIds(List<JsonNode> externalIds) {
		this.externalIds = externalIds;
	}

	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	public boolean isExcluded() {
		return isExcluded;
	}

	public void setExcluded(boolean isExcluded) {
		this.isExcluded = isExcluded;
	}

	public List<JsonNode> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<JsonNode> keywords) {
		this.keywords = keywords;
	}

	public JsonNode getProduct() {
		return product;
	}

	public void setProduct(JsonNode product) {
		this.product = product;
	}

	public Relationships getRelationships() {
		return relationships;
	}

	public void setRelationships(Relationships relationships) {
		this.relationships = relationships;
	}

	public boolean isRequiresApproval() {
		return requiresApproval;
	}

	public void setRequiresApproval(boolean requiresApproval) {
		this.requiresApproval = requiresApproval;
	}

	public JsonNode getResellerAmount() {
		return resellerAmount;
	}

	public void setResellerAmount(JsonNode resellerAmount) {
		this.resellerAmount = resellerAmount;
	}

	public JsonNode getResellerTargetAmount() {
		return resellerTargetAmount;
	}

	public void setResellerTargetAmount(JsonNode resellerTargetAmount) {
		this.resellerTargetAmount = resellerTargetAmount;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public JsonNode getSystemProperties() {
		return systemProperties;
	}

	public void setSystemProperties(JsonNode systemProperties) {
		this.systemProperties = systemProperties;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public JsonNode getTargetAmount() {
		return targetAmount;
	}

	public void setTargetAmount(JsonNode targetAmount) {
		this.targetAmount = targetAmount;
	}

	public String getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(String targetDate) {
		this.targetDate = targetDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public JsonNode getUpsellAmount() {
		return upsellAmount;
	}

	public void setUpsellAmount(JsonNode upsellAmount) {
		this.upsellAmount = upsellAmount;
	}

	@Override
	public String toString() {
		return "Offer [_id=" + _id + ", amount=" + amount + ", description=" + description + ", displayName="
				+ displayName + ", dq=" + dq + ", endDate=" + endDate + ", extensions=" + extensions + ", externalIds="
				+ externalIds + ", isApproved=" + isApproved + ", isExcluded=" + isExcluded + ", keywords=" + keywords
				+ ", product=" + product + ", relationships=" + relationships + ", requiresApproval=" + requiresApproval
				+ ", resellerAmount=" + resellerAmount + ", resellerTargetAmount=" + resellerTargetAmount
				+ ", startDate=" + startDate + ", systemProperties=" + systemProperties + ", tags=" + tags
				+ ", targetAmount=" + targetAmount + ", targetDate=" + targetDate + ", type=" + type + ", upsellAmount="
				+ upsellAmount + "]";
	}

}
