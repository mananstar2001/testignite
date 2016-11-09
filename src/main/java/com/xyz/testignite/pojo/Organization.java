package com.xyz.testignite.pojo;

import java.util.List;

import org.apache.ignite.cache.query.annotations.QuerySqlField;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Organization {

	@QuerySqlField(index = true)
	String _id;
	List<JsonNode> contactNumbers;
	String department;
	@QuerySqlField(index = true)
	String displayName;
	List<JsonNode> dq;
	List<JsonNode> emailAddresses;
	JsonNode extensions;
	List<JsonNode> externalIds;
	String firstName;
	String imageURL;
	String industry;
	String jobTitle;
	List<JsonNode> keywords;
	String lastName;
	String membership;
	String middleName;
	String name;
	JsonNode preferredLanguage;
	JsonNode relationships;
	String role;
	String superUser;
	JsonNode systemProperties;
	List<JsonNode> tags;
	String title;
	String type;
	String uiProfile;
	List<JsonNode> websiteAddresses;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public List<JsonNode> getContactNumbers() {
		return contactNumbers;
	}

	public void setContactNumbers(List<JsonNode> contactNumbers) {
		this.contactNumbers = contactNumbers;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
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

	public List<JsonNode> getEmailAddresses() {
		return emailAddresses;
	}

	public void setEmailAddresses(List<JsonNode> emailAddresses) {
		this.emailAddresses = emailAddresses;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public List<JsonNode> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<JsonNode> keywords) {
		this.keywords = keywords;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMembership() {
		return membership;
	}

	public void setMembership(String membership) {
		this.membership = membership;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public JsonNode getPreferredLanguage() {
		return preferredLanguage;
	}

	public void setPreferredLanguage(JsonNode preferredLanguage) {
		this.preferredLanguage = preferredLanguage;
	}

	public JsonNode getRelationships() {
		return relationships;
	}

	public void setRelationships(JsonNode relationships) {
		this.relationships = relationships;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSuperUser() {
		return superUser;
	}

	public void setSuperUser(String superUser) {
		this.superUser = superUser;
	}

	public JsonNode getSystemProperties() {
		return systemProperties;
	}

	public void setSystemProperties(JsonNode systemProperties) {
		this.systemProperties = systemProperties;
	}

	public List<JsonNode> getTags() {
		return tags;
	}

	public void setTags(List<JsonNode> tags) {
		this.tags = tags;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUiProfile() {
		return uiProfile;
	}

	public void setUiProfile(String uiProfile) {
		this.uiProfile = uiProfile;
	}

	public List<JsonNode> getWebsiteAddresses() {
		return websiteAddresses;
	}

	public void setWebsiteAddresses(List<JsonNode> websiteAddresses) {
		this.websiteAddresses = websiteAddresses;
	}

	@Override
	public String toString() {
		return "Organization [_id=" + _id + ", contactNumbers=" + contactNumbers + ", department=" + department
				+ ", displayName=" + displayName + ", dq=" + dq + ", emailAddresses=" + emailAddresses + ", extensions="
				+ extensions + ", externalIds=" + externalIds + ", firstName=" + firstName + ", imageURL=" + imageURL
				+ ", industry=" + industry + ", jobTitle=" + jobTitle + ", keywords=" + keywords + ", lastName="
				+ lastName + ", membership=" + membership + ", middleName=" + middleName + ", name=" + name
				+ ", preferredLanguage=" + preferredLanguage + ", relationships=" + relationships + ", role=" + role
				+ ", superUser=" + superUser + ", systemProperties=" + systemProperties + ", tags=" + tags + ", title="
				+ title + ", type=" + type + ", uiProfile=" + uiProfile + ", websiteAddresses=" + websiteAddresses
				+ "]";
	}
	

}
