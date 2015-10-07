package org.missionarogya.sherp.model.service;

import java.util.Date;

import org.missionarogya.sherp.controller.object.request.Answer;
import org.missionarogya.sherp.controller.object.request.AnswerType;
import org.missionarogya.sherp.model.dao.AppDao;
import org.missionarogya.sherp.model.dao.object.InterviewAnswers;
import org.missionarogya.sherp.model.dao.object.InterviewDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service("AppService")
@Transactional
public class AppServiceImpl implements AppService{
	@Autowired
    private AppDao dao;
	public void insertAnswer(AnswerType answers) {
		// TODO Auto-generated method stub
		System.out.println("Insert Answer-Sumon");
		InterviewDetails detail = new InterviewDetails();
		detail.setInterviewId(1);
		detail.setInterviewerId(answers.getInterviewer_id());
		detail.setIntervieweeId(answers.getInterviewee_id());
		detail.setLatitude(answers.getInterview_dttm().getLatitude());
		detail.setLongitude(answers.getInterview_dttm().getLongitude());
		
		detail.setVenue(answers.getVenue());
		dao.saveInterview(detail);
		/*
		InterviewAnswers ans; 
		for(Answer answer : answers.getAnswer()){
			ans = new InterviewAnswers();
			ans.setAnswer(answer.getAnswer());
			ans.setQuestionId(answer.getQuestion());
			dao.saveAnswer(ans);
		}*/
		System.out.println("Insert Answer - End");
		
	}
}
