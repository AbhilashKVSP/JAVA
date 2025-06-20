package com.LearnRest.first_restApp.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Base64;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SurveyResourceIT {
	private static String Specific_Question_URL = "/surveys/Survey1/questions/Question1";
	private static String AllQuestion_BySurvey = "/surveys/Survey1/questions";

	@Autowired
	private TestRestTemplate template;

	@Test
	void retrirveSurveyQuestionById_Basic() throws JSONException {
		
		HttpHeaders header = createHttpContentTypeAndAuthHeaders();

		HttpEntity<String> httpEntity = new HttpEntity<String>(null, header);
		ResponseEntity<String> responseEntity = template.exchange(Specific_Question_URL, HttpMethod.GET, httpEntity,
				String.class);

		String expectedResponse = """
				{"id":"Question1",
				"description":"Most Popular Cloud Platform Today",
				"correctAnswer":"AWS"}
							""";
		assertTrue(responseEntity.getStatusCode().is2xxSuccessful());

		JSONAssert.assertEquals(expectedResponse, responseEntity.getBody(), false);
		assertEquals("application/json", responseEntity.getHeaders().get("Content-Type").get(0));
	}

	@Test
	void AddSurveyQuestion_Basic() throws JSONException {
		String Requestbody = """
				{"description":"Most Popular Language","options":["Java","Python","Pascal"],"correctAnswer":"Java"}
				""";
		HttpHeaders header = createHttpContentTypeAndAuthHeaders();

		HttpEntity<String> httpEntity = new HttpEntity<String>(Requestbody, header);
		ResponseEntity<String> responseEntity = template.exchange(AllQuestion_BySurvey, HttpMethod.POST, httpEntity,
				String.class);

		assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
		String NewQuestionLoc = responseEntity.getHeaders().get("Location").get(0);
		assertTrue(NewQuestionLoc.contains("/surveys/Survey1/questions/"));
		
		ResponseEntity<String> responseEntityDelete = template.exchange(NewQuestionLoc, HttpMethod.DELETE, httpEntity,
				String.class);
		assertTrue(responseEntityDelete.getStatusCode().is2xxSuccessful());
	}

	private HttpHeaders createHttpContentTypeAndAuthHeaders() {
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json");
		header.add("Authorization", "Basic "+ performBasicAuthEncoding("Abhilash","abbui"));
		return header;
	}

	@Test
	void retrieveQuestionsBySurvey_Basic() throws JSONException {
		HttpHeaders header = createHttpContentTypeAndAuthHeaders();

		HttpEntity<String> httpEntity = new HttpEntity<String>(null, header);
		ResponseEntity<String> responseEntity = template.exchange(AllQuestion_BySurvey, HttpMethod.GET, httpEntity,
				String.class);

		String expectedResponse = """
				[{"id":"Question1"},
				{"id":"Question2"},
				{"id":"Question3"}]
							""";
		assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
		JSONAssert.assertEquals(expectedResponse, responseEntity.getBody(), false);
		assertEquals("application/json", responseEntity.getHeaders().get("Content-Type").get(0));
	}
	
	String performBasicAuthEncoding(String user,String password) {
		String combined = user +":"+ password;
		byte[] encodedBytes = Base64.getEncoder().encode(combined.getBytes());
		return new String(encodedBytes);
	}
}
