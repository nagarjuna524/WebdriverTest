package api.tests.rest;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.Test;

import edu.framework.base.APIBaseTest;

public class HelloRest extends APIBaseTest {

	@Test  // http://www.baeldung.com/integration-testing-a-rest-api
	public void givenUserDoesNotExists_whenUserInfoIsRetrieved_then404IsReceived()
			throws ClientProtocolException, IOException {

		// Given
		String name = RandomStringUtils.randomAlphabetic(8);
		HttpUriRequest request = new HttpGet("https://api.github.com/users/"
				+ name);
		
		HttpUriRequest postRequest = new HttpPost("https://api.github.com/users/");

		// When
		HttpResponse httpResponse = HttpClientBuilder.create().build()
				.execute(request);

		// Then
//		assertThat(httpResponse.getStatusLine().getStatusCode(),
//				equalTo(HttpStatus.SC_NOT_FOUND));
	}
}
