package com.xyz.testignite.pojo;

import org.apache.ignite.cache.query.annotations.QuerySqlField;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Relationships {

	JsonNode clientOperation;
	JsonNode clientRegion;
	JsonNode clientSegment;
	JsonNode clientSubRegion;
	JsonNode clientTerritory;
	JsonNode clientTheatre;

	@QuerySqlField(index = true)
	Customer customer;
	JsonNode oppGeoKey;
	JsonNode predecessor;
	JsonNode product;
	JsonNode quote;

	public JsonNode getClientOperation() {
		return clientOperation;
	}

	public void setClientOperation(JsonNode clientOperation) {
		this.clientOperation = clientOperation;
	}

	public JsonNode getClientRegion() {
		return clientRegion;
	}

	public void setClientRegion(JsonNode clientRegion) {
		this.clientRegion = clientRegion;
	}

	public JsonNode getClientSegment() {
		return clientSegment;
	}

	public void setClientSegment(JsonNode clientSegment) {
		this.clientSegment = clientSegment;
	}

	public JsonNode getClientSubRegion() {
		return clientSubRegion;
	}

	public void setClientSubRegion(JsonNode clientSubRegion) {
		this.clientSubRegion = clientSubRegion;
	}

	public JsonNode getClientTerritory() {
		return clientTerritory;
	}

	public void setClientTerritory(JsonNode clientTerritory) {
		this.clientTerritory = clientTerritory;
	}

	public JsonNode getClientTheatre() {
		return clientTheatre;
	}

	public void setClientTheatre(JsonNode clientTheatre) {
		this.clientTheatre = clientTheatre;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public JsonNode getOppGeoKey() {
		return oppGeoKey;
	}

	public void setOppGeoKey(JsonNode oppGeoKey) {
		this.oppGeoKey = oppGeoKey;
	}

	public JsonNode getPredecessor() {
		return predecessor;
	}

	public void setPredecessor(JsonNode predecessor) {
		this.predecessor = predecessor;
	}

	public JsonNode getProduct() {
		return product;
	}

	public void setProduct(JsonNode product) {
		this.product = product;
	}

	public JsonNode getQuote() {
		return quote;
	}

	public void setQuote(JsonNode quote) {
		this.quote = quote;
	}

	@Override
	public String toString() {
		return "Relationships [clientOperation=" + clientOperation + ", clientRegion=" + clientRegion
				+ ", clientSegment=" + clientSegment + ", clientSubRegion=" + clientSubRegion + ", clientTerritory="
				+ clientTerritory + ", clientTheatre=" + clientTheatre + ", customer=" + customer + ", oppGeoKey="
				+ oppGeoKey + ", predecessor=" + predecessor + ", product=" + product + ", quote=" + quote + "]";
	}

}
