package com.LearnRest.first_restApp.survey;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

//import org.slf4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class SurveyService {
	private static List<Survey> surveys = new ArrayList<Survey>();

	static {
		Question question1 = new Question("Question1", "Most Popular Cloud Platform Today",
				Arrays.asList("AWS", "Azure", "Google Cloud", "Oracle Cloud"), "AWS");
		Question question2 = new Question("Question2", "Fastest Growing Cloud Platform",
				Arrays.asList("AWS", "Azure", "Google Cloud", "Oracle Cloud"), "Google Cloud");
		Question question3 = new Question("Question3", "Most Popular DevOps Tool",
				Arrays.asList("Kubernetes", "Docker", "Terraform", "Azure DevOps"), "Kubernetes");

		List<Question> questions = new ArrayList<>(Arrays.asList(question1, question2, question3));

		Survey survey = new Survey("Survey1", "My Favorite Survey", "Description of the Survey", questions);

		surveys.add(survey);
	}

	public List<Survey> retrieveAllSurveys() {
		return surveys;
	}

	public Survey retrieveSurveyById(String surveyId) {
		
		Predicate<? super Survey> predicate = Survey -> Survey.getId().equals(surveyId);
		Optional<Survey> OptsSurvey = surveys.stream().filter(predicate).findFirst();
		if(OptsSurvey.isEmpty()) return null;
		return OptsSurvey.get();
	}

	public List<Question> retrirveAllSurveyQuestions(String surveyId) {
		Survey surveyById = retrieveSurveyById(surveyId);
		if(surveyById == null) return null;
		return surveyById.getQuestions();
	}

	public Question retrirveSurveyQuestionById(String surveyId, String questionId) {
		Survey surveyById = retrieveSurveyById(surveyId);
		if(surveyById == null) return null;
		
		Predicate<? super Question> predicate =
				Question -> Question.getId().equals(questionId);
		Optional<Question> optsQuestion = surveyById.getQuestions().stream().filter(predicate).findFirst();
		
		if(optsQuestion.isEmpty()) return null;
		return optsQuestion.get();
	}

	public String addNewSurveyQuestion(String surveyId, Question question) {
		List<Question> questions = retrirveAllSurveyQuestions(surveyId);
		question.setId(randomId());
		questions.add(question);
		return question.getId();
	}

	private String randomId() {
		SecureRandom secureRandom = new SecureRandom();
		String randomId = new BigInteger(32,secureRandom).toString();
		return randomId;
	}

	public boolean DeleteByQuestionId(String surveyId, String questionId) {
		List<Question> questions = retrirveAllSurveyQuestions(surveyId);
		if(questions == null) return false;
		Predicate<? super Question> predicate =
				Question -> Question.getId().equals(questionId);

		boolean deleteStatus = questions.removeIf(predicate);
		if(deleteStatus) return true;
		return false;
	}

	public void ModifyQuestion(String surveyId, String questionId, Question question) {
	
		DeleteByQuestionId(surveyId,questionId);
		addNewSurveyQuestion(surveyId, question);
	}
	
}
