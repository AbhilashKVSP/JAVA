package com.LearnRest.first_restApp.survey;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

class JsonAssertTest{

	@Test
	void JsonAssertTest_Basic() throws JSONException {
		
		String expectedResponse = """
				{"id":"Question1",
				"description":"Most Popular Cloud Platform Today",
				"correctAnswer":"AWS"}
							""";
		String actualResponse = """
				{"id":"Question1",
				"description":"Most Popular Cloud Platform Today",
				"options":["AWS","Azure","Google Cloud","Oracle Cloud"],
				"correctAnswer":"AWS"}
							""";
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);
	}

}
