package api.tests.rest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.testng.annotations.Test;

import edu.framework.base.APIBaseTest;

// http://stackoverflow.com/questions/7181534/http-post-using-json-in-java

public class RestApiAutomationTest extends APIBaseTest {

	String baseURL = "https://jsonplaceholder.typicode.com";

	public RestApiAutomationTest() {
		// TODO Auto-generated constructor stub
	}

	@Test
	public void testGetApiRequest() throws ClientProtocolException, IOException {

		System.out.println("Testing GET Request");
		String path = "/posts/1";
		String restURL = baseURL + path;

		HttpUriRequest request = new HttpGet(restURL);
		HttpResponse response = HttpClientBuilder.create().build().execute(request);

		System.out.println(response.getStatusLine());
		System.out.println(response.getStatusLine().getStatusCode());
		System.out.println(response.getEntity().getContent().toString());
	}
	
	@Test
	public void testGetApiRequestValues() throws ClientProtocolException, IOException {
		
		System.out.println("Testing GET Request: Values");
		String path = "/posts/1";
		String restURL = baseURL + path;
		
		HttpUriRequest request = new HttpGet(restURL);
		HttpClient client = HttpClientBuilder.create().build();
		HttpResponse response = client.execute(request);
		
		String jsonString = EntityUtils.toString(response.getEntity());
		JSONObject jsonObject = (JSONObject) JSONValue.parse(jsonString);
		
		jsonToMap(jsonString);
//		System.out.println(jsonObject);
	}

	@Test
	public void testApiPostRequest() throws ClientProtocolException, IOException {
		// https://www.javacodegeeks.com/2012/09/simple-rest-client-in-java.html
		// https://reqres.in/
		
		String uri = "https://reqres.in/api/users/";
		HttpPost request = new HttpPost(uri);
		HttpClient client = HttpClientBuilder.create().build();
		
//		JSONObject jsonObject = new JSONObject();
//		jsonObject.put("name", "morpheus");
//		jsonObject.put("job", "leader");
//		StringEntity input = new StringEntity(jsonObject.toString());
		
		StringEntity input = new StringEntity("{\"name\": \"morpheus\", \"job\":\"leader\"}");
		request.setEntity(input);
		
		HttpResponse response = client.execute(request);
		System.out.println(response.getStatusLine().getStatusCode());
		System.out.println(response.getEntity().getClass());
	}
	
	
	public static void jsonToMap(String t) {

        HashMap<String, String> map = new HashMap<String, String>();
        JSONObject jsonObject = (JSONObject) JSONValue.parse(t);
        Set<String> keySet = jsonObject.keySet();
        Iterator<String> keysIterator = keySet.iterator();

        while( keysIterator.hasNext() ){
            String key = (String)keysIterator.next();
            String value = jsonObject.get(key).toString();
            map.put(key, value);
        }

//        System.out.println("json : "+jsonObject);
//        System.out.println("map : "+map);
        
        Iterator<String> it = map.keySet().iterator();

		while (it.hasNext()) {
			String keyValue = it.next();
			System.out.println("Key value: " + keyValue + " Value : " + map.get(keyValue));
		}
    }
	
	
	// HttpClientBuilder builder = HttpClientBuilder.create();
			// HttpClient httpClient = builder.build();
			// HttpUriRequest getRequest = new HttpGet(restURL);
	
	
//	 public static HashMap<String, Object> parseJsonString(String content) {
//	 HashMap<String, Object> map = new HashMap<String, Object>();
//	 try {
//	 map = objectMapper.readValue(content, typeRef);
//	 } catch (Exception e) {
//	 System.out.println("Error while parsing the object");
//	 }
//	 return map;
//	 }
	//
	// public static Map<String, Object>[] parseJsonArrayOfMaps(String
	// jsonString) {
	// try {
	// return objectMapper.readValue(jsonString, arrayOfMapsTypeRef);
	// } catch (IOException e) {
	// System.out.println("Error while parsing the object");
	// return null;
	// }
	// }
}
