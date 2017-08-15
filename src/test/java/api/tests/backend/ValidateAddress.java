/**
 * 
 */
package api.tests.backend;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author nagarjuna
 * 
 */
public class ValidateAddress {

	@Test(enabled=true)
	public void testValidateAddress() throws ClientProtocolException,
			IOException, ParseException {

		String completeURL = "https://maps.googleapis.com/maps/api/geocode/json"
				+ "?address=1600+Amphitheatre+Parkway,+Mountain+View,+CA"
				+ "&key=AIzaSyAiK60P-niIgfLDQpDbMlmmuALb1Vm8hk4";

		int HTTP_STATUS_200 = 200;

		// Create Request object
		HttpGet request = new HttpGet(completeURL);

		// Build Request
		HttpClient httpClient = HttpClientBuilder.create().build();

		// Execute Request
		HttpResponse httpResponse = httpClient.execute(request);

		// Validate Response object (Success)
		Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(),
				HTTP_STATUS_200);

		System.out.println("####################################");
		String jsonString = EntityUtils.toString(httpResponse.getEntity());
		JSONObject jsonObject = (JSONObject) JSONValue.parse(jsonString);
		System.out.println(jsonObject);

		System.out.println("####################################");
		String addressField = getAddress(jsonObject);
	}

	private String getAddress(JSONObject jsonObject) {
		System.out.println(((JSONArray) jsonObject.get("results")).get(0));
		return null;
	}
}
