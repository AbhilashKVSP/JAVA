package com.LearnRest.first_restApp.survey;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class SurveyResource {

	private SurveyService surveyService;

	@Autowired
	public SurveyResource(SurveyService surveyService) {
		super();
		this.surveyService = surveyService;
	}

	@RequestMapping("/surveys")
	public List<Survey> retrieveAllSurveys() {
		return surveyService.retrieveAllSurveys();

	}

	@RequestMapping("/surveys/{surveyId}")
	public Survey retrieveSurveyById(@PathVariable String surveyId) {
		Survey filteredSurvey = surveyService.retrieveSurveyById(surveyId);
		if (filteredSurvey == null)
			throw new ResponseStatusException(HttpStatus.NO_CONTENT);
		return filteredSurvey;

	}

	@RequestMapping("/surveys/{surveyId}/questions")
	public List<Question> retrirveAllSurveyQuestions(@PathVariable String surveyId) {
		List<Question> questions = surveyService.retrirveAllSurveyQuestions(surveyId);
		if (questions == null)
			throw new ResponseStatusException(HttpStatus.NO_CONTENT);
		return questions;
	}

	@RequestMapping("/surveys/{surveyId}/questions/{questionId}")
	public Question retrirveSurveyQuestionById(@PathVariable String surveyId, @PathVariable String questionId) {
		Question question = surveyService.retrirveSurveyQuestionById(surveyId, questionId);
		if (question == null)
			throw new ResponseStatusException(HttpStatus.NO_CONTENT);
		return question;
	}

	@RequestMapping(value = "/surveys/{surveyId}/questions", method = RequestMethod.POST)
	public ResponseEntity<Object> addNewSurveyQuestion(@PathVariable String surveyId, @RequestBody Question question) {
		String questionId = surveyService.addNewSurveyQuestion(surveyId, question);
		// URL/{{questionId}}
		URI path = ServletUriComponentsBuilder.fromCurrentRequest().path("/{questionId}").buildAndExpand(questionId)
				.toUri();
		return ResponseEntity.created(path).build();

	}
	
	@RequestMapping(value = "/surveys/{surveyId}/questions/{questionId}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> DeleteByQuestionId(@PathVariable String surveyId, @PathVariable String questionId) {
		boolean deleteByQuestionId = surveyService.DeleteByQuestionId(surveyId, questionId);
		if(deleteByQuestionId) return ResponseEntity.noContent().build();
		return ResponseEntity.internalServerError().build();	

	}
	
	@RequestMapping(value = "/surveys/{surveyId}/questions/{questionId}", method = RequestMethod.PUT)
	public ResponseEntity<Object> ModifyQuestion(@PathVariable String surveyId,
			@PathVariable String questionId, 
			@RequestBody Question question) {
		surveyService.ModifyQuestion(surveyId, questionId,question);
		return ResponseEntity.ok(null);

	}
}
