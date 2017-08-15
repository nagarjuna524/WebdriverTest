/**
 * 
 */
package api.tests.backend;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author nagarjuna
 * 
 */
public class SanityTest {

	@BeforeTest
	public void setup() {

	}

	@Test(enabled = true)
	public void testSanityCase() throws ClientProtocolException, IOException,
			ParseException {

		String url = "https://maps.googleapis.com/maps/api/geocode/json";
		String completeURL = "https://maps.googleapis.com/maps/api/geocode/json"
				+ "?address=1600+Amphitheatre+Parkway,+Mountain+View,+CA"
				+ "&key=AIzaSyAiK60P-niIgfLDQpDbMlmmuALb1Vm8hk4";
		String address = "1600+Amphitheatre+Parkway,+Mountain+View,+CA";
		String key = "AIzaSyAiK60P-niIgfLDQpDbMlmmuALb1Vm8hk4";

		int HTTP_STATUS_200 = 200;

		HashMap<String, String> locationMap = new HashMap<String, String>();
		locationMap.put("TajMahal", "ChIJbf8C1yFxdDkR3n12P4DkKt0");

		// Create Request object
		HttpGet request = new HttpGet(completeURL);		

		// Build Request
		HttpClient httpClient = HttpClientBuilder.create().build();

		// Execute Request
		HttpResponse httpResponse = httpClient.execute(request);

		// Validate Response object (Success)
		Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(),
				HTTP_STATUS_200);

		System.out.println("Output: ####################################");
		String jsonString = EntityUtils.toString(httpResponse.getEntity());
		JSONObject jsonObject = (JSONObject) JSONValue.parse(jsonString);
		System.out.println(jsonObject);

		System.out.println("addressField: ####################################");
		String addressField = getAddress(jsonObject);
		System.out.println(addressField);
		
		
		System.out.println("####################################");
		
		System.out.println(jsonObject.get("results"));
		System.out.println("####################################");
		
		JSONArray jArray = (JSONArray) jsonObject.get("results");
		
		JSONObject subObject = (JSONObject) jArray.get(0);
		
		
		
		System.out.println(subObject.get("address_components"));
//		for (int i = 0; i < jArray.size(); ++i) {
//		    System.out.println(jArray.get(i));
//		    System.out.println("###");
//		}
		
		
		
//		System.out.println(jsonObject.get("results").getClass());
		
		
		
//		JSONParser parser = new JSONParser();
//		Object obj = parser.parse(jsonObject.get("results").toString());
//		JSONArray array = (JSONArray) obj;
//		
//		JSONArray jArray = (JSONArray) parser.parse(jsonObject.get("results").toString());
//		
//		System.out.println("======the 1st element of array======");
//		System.out.println(array.get(0));
//		
//		System.out.println("======the 2nd element of array======");
//		System.out.println(parser.parse(array.get(0).toString()));
//		
//		System.out.println("======the 2nd element of array======");
//		System.out.println(array.get(2));

		// String subJsonString = jsonObject.get("results").toString();
		// JSONObject subJsonObject = (JSONObject)
		// JSONValue.parse(subJsonString);
		// System.out.println(subJsonObject.get("address_components"));
		// System.out.println("####################################");

	}

	private String getAddress(JSONObject jsonObject) {
		return ((JSONArray)jsonObject.get("results")).get(0).toString();
	}

	@Test(enabled = false)
	public void testValidateLocation() throws ParseException {
		JSONParser parser = new JSONParser();

		System.out.println("=======decode=======");

		String s = "[0,{\"1\":{\"2\":{\"3\":{\"4\":[5,{\"6\":7}]}}}}]";
		Object obj = parser.parse(s);
		JSONArray array = (JSONArray) obj;
		System.out.println("======the 2nd element of array======");
		System.out.println(array.get(1));
		System.out.println();

		JSONObject obj2 = (JSONObject) array.get(1);
		System.out.println("======field \"1\"==========");
		System.out.println(obj2.get("1"));

		s = "{}";
		obj = parser.parse(s);
		System.out.println(obj);

		s = "[5,]";
		obj = parser.parse(s);
		System.out.println(obj);

		s = "[5,,2]";
		obj = parser.parse(s);
		System.out.println(obj);
	}

	public HttpGet buildGetRequest(String requestUrl, String locationName,
			String key) {

		String completeURL = "https://maps.googleapis.com/maps/api/geocode/json?address=TajMahal&key=AIzaSyAiK60P-niIgfLDQpDbMlmmuALb1Vm8hk4";

		// Create Request object
		HttpGet request = new HttpGet(completeURL);
		return request;
	}
}
