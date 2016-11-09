package com.xyz.testignite.persistence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public class CustomSSHttpClient {

	DefaultHttpClient httpClient = new DefaultHttpClient();
	String line = "";

	public String getRequest(String url) throws ClientProtocolException, IOException {

		StringBuffer responseBuffer = new StringBuffer();

		HttpGet getRequest = new HttpGet(url);
		getRequest.addHeader("accept", "application/json");
		getRequest.addHeader("Content-type", "application/json");

		HttpResponse response = this.httpClient.execute(getRequest);

		if (response.getStatusLine().getStatusCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));

		while ((line = br.readLine()) != null) {
			responseBuffer.append(line);
		}

		return responseBuffer.toString();
	}

	public int postRequest(String url, String requestJson) throws ClientProtocolException, IOException {

		HttpResponse response = null;

		HttpPost postRequest = new HttpPost(url);

		StringEntity request = new StringEntity(requestJson);
		request.setContentType("application/json");
		postRequest.setEntity(request);
		postRequest.addHeader("accept", "application/json");
		postRequest.addHeader("Content-type", "application/json");

		response = this.httpClient.execute(postRequest);

		if (response.getStatusLine().getStatusCode() != 201 && response.getStatusLine().getStatusCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));

		while ((line = br.readLine()) != null) {
			// ignore
		}

		return response.getStatusLine().getStatusCode();

	}

	public String postFabricRequest(String url, String requestJson) throws ClientProtocolException, IOException {

		HttpResponse response = null;

		StringBuilder responseBuilder = new StringBuilder();

		HttpPost postRequest = new HttpPost(url);

		StringEntity request = new StringEntity(requestJson);
		request.setContentType("application/json");

		// postRequest.setHeader("accept", "text/plain");
		postRequest.setHeader("Content-Type", "application/json");
		postRequest.setHeader("username", "bill.moor@ciscoinc.com");
		postRequest.setHeader("platformVersion", "1.0");
		postRequest.setHeader("password", "passwordone");
		postRequest.setEntity(request);

		response = this.httpClient.execute(postRequest);

		if (response.getStatusLine().getStatusCode() != 201 && response.getStatusLine().getStatusCode() != 200) {
			String msg = response.getStatusLine().getReasonPhrase();
			throw new RuntimeException(
					"Failed : HTTP error code : " + response.getStatusLine().getStatusCode() + "::" + msg);
		}

		BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));

		while ((line = br.readLine()) != null) {
			responseBuilder.append(line);
		}

		return responseBuilder.toString();

	}

	public int putRequest(String url, String requestJson) throws ClientProtocolException, IOException {

		HttpResponse response = null;

		HttpPut putRequest = new HttpPut(url);
		StringEntity request = new StringEntity(requestJson);
		request.setContentType("application/json");
		putRequest.setEntity(request);
		putRequest.addHeader("accept", "application/json");
		putRequest.addHeader("Content-type", "application/json");

		response = this.httpClient.execute(putRequest);

		if (response.getStatusLine().getStatusCode() != 200 && response.getStatusLine().getStatusCode() != 204) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));

		while ((line = br.readLine()) != null) {
			// ignore
		}

		return response.getStatusLine().getStatusCode();
	}

	public void deleteRequest(String url) throws ClientProtocolException, IOException {

		HttpDelete deleteRequest = new HttpDelete(url);
		deleteRequest.addHeader("accept", "application/json");
		deleteRequest.addHeader("Content-type", "application/json");

		HttpResponse response = this.httpClient.execute(deleteRequest);

		if (response.getStatusLine().getStatusCode() != 200 && response.getStatusLine().getStatusCode() != 204) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
		}

	}

	/*
	 * public static void main(String args[]) { CustomSSHttpClient client = new
	 * CustomSSHttpClient();
	 * 
	 * Opportunity responseOpportunity = null;
	 * 
	 * DataNode dataNode = null; ObjectMapper JsonMapper = new ObjectMapper();
	 * final String APPLICATION_BASE_URL =
	 * "http://172.26.45.69:9000/datafabric/ciscoinc/Opportunity/find"; String
	 * request = args[0];
	 * 
	 * try { // System.out.println(client.getRequest(
	 * "http://localhost:8080/JAXRSJsonCRUDExample/rest/countries"));
	 * 
	 * 
	 * for (int i = 0; i < 1001; i += 100) { request =
	 * "{ \"filter\": { \"isSubordinate\": false }," +
	 * "\"params\": { \"start\": startValue, \"limit\": 100,\"sort\":{\"_id\":1} }}"
	 * ; request = request.replace("startValue", Integer.toString(i)); //
	 * System.out.println("request body: " + request); responseOpportunity =
	 * JsonMapper.readValue( client.postFabricRequest(APPLICATION_BASE_URL,
	 * request), Opportunity.class);
	 * 
	 * for (JsonNode responseJSONData : responseOpportunity.getData()) {
	 * System.out.println("Response data String: " +
	 * responseJSONData.toString()); }
	 * 
	 * if (!responseOpportunity.isHasMoreRecords()) break; }
	 * 
	 * 
	 * for (int i = 0; i < 10; i += 100) { request = "{ \"filter\": { }," +
	 * "\"params\": { \"start\": startValue, \"limit\": 5,\"sort\":{\"_id\":1} }}"
	 * ; request = request.replace("startValue", Integer.toString(i)); //
	 * System.out.println("request body: " + request); dataNode =
	 * JsonMapper.readValue(client.postFabricRequest(APPLICATION_BASE_URL,
	 * request), DataNode.class);
	 * 
	 * for (Offer responseOffer : dataNode.getData()) { System.out.println(
	 * "Response data String: " + responseOffer.toString()); }
	 * 
	 * if (!dataNode.isHasMoreRecords()) break; }
	 * 
	 * } catch (IOException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } // client.deleteRequest(
	 * "http://localhost:8080/JAXRSJsonCRUDExample/rest/countries/8"); //
	 * System.out.println(client.getRequest(
	 * "http://localhost:8080/JAXRSJsonCRUDExample/rest/countries")); // String
	 * postCountry = //
	 * "{\"id\":6,\"countryName\":\"USA\",\"population\":30000}"; //
	 * System.out.println(client.postRequest(
	 * "http://localhost:8080/JAXRSJsonCRUDExample/rest/countries", //
	 * postCountry));
	 * 
	 * String putCountry =
	 * "{\"id\":6,\"countryName\":\"USA\",\"population\":50000}"; try {
	 * System.out.println( client.putRequest(
	 * "http://localhost:8080/JAXRSJsonCRUDExample/rest/countries",
	 * putCountry)); } catch (IOException e) { // TODO Auto-generated catch
	 * block e.printStackTrace(); } try { System.out.println(client.getRequest(
	 * "http://localhost:8080/JAXRSJsonCRUDExample/rest/countries")); } catch
	 * (IOException e) { // TODO Auto-generated catch block e.printStackTrace();
	 * }
	 * 
	 * }
	 */
}
