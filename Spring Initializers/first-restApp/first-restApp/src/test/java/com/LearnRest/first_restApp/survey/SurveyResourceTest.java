package com.LearnRest.first_restApp.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(controllers = SurveyResource.class)
@AutoConfigureMockMvc(addFilters=false)
class SurveyResourceTest {

	@MockBean
	private SurveyService surveyService;

	@Autowired
	private MockMvc mockMVC;

	private static String SPECIFIC_QUESTION_URL = "http://localhost:8080/surveys/Survey1/questions/Question1";
	private static String GENERIC_QUESTION_URL = "http://localhost:8080/surveys/Survey1/questions";

	@Test
	void retrirveSurveyQuestionById_204Error() throws Exception {

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(SPECIFIC_QUESTION_URL)
				.accept(MediaType.APPLICATION_JSON);
		MvcResult MvcResult = mockMVC.perform(requestBuilder).andReturn();
		assertEquals("", MvcResult.getResponse().getContentAsString());
		assertEquals(204, MvcResult.getResponse().getStatus());
	}

	@Test
	void retrirveSurveyQuestionById_BasicScenario() throws Exception {

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(SPECIFIC_QUESTION_URL)
				.accept(MediaType.APPLICATION_JSON);
		Question question = new Question("Question1", "Most Popular Cloud Platform Today",
				Arrays.asList("AWS", "Azure", "Google Cloud", "Oracle Cloud"), "AWS");

		when(surveyService.retrirveSurveyQuestionById("Survey1", "Question1")).thenReturn(question);

		MvcResult MvcResult = mockMVC.perform(requestBuilder).andReturn();
		String expectedResponse = "{\"id\":\"Question1\",\"description\":\"Most Popular Cloud Platform Today\",\"options\":[\"AWS\",\"Azure\",\"Google Cloud\",\"Oracle Cloud\"],\"correctAnswer\":\"AWS\"}";

		assertEquals(expectedResponse, MvcResult.getResponse().getContentAsString());
		assertEquals(200, MvcResult.getResponse().getStatus());
	}

	@Test
	void addNewSurveyQuestion_BasicScenario() throws Exception {

		String requestBody = """
								{
				  "description":"Most Popular Language",
				  "options":[
				    "Java",
				    "Python",
				    "Pascal"],
				  "correctAnswer":"Java"
				}
								""";

		when(surveyService.addNewSurveyQuestion(anyString(), any())).thenReturn("SOME_ID");
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(GENERIC_QUESTION_URL)
				.accept(MediaType.APPLICATION_JSON).content(requestBody).contentType(MediaType.APPLICATION_JSON);
		MvcResult MvcResult = mockMVC.perform(requestBuilder).andReturn();
		
		String expectedLocHeader = "http://localhost:8080/surveys/Survey1/questions/SOME_ID";
		assertTrue(MvcResult.getResponse().getHeaderValue("Location").equals(expectedLocHeader));
		assertEquals(201, MvcResult.getResponse().getStatus());
	}

}
