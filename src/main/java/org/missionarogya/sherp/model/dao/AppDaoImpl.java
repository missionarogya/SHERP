package org.missionarogya.sherp.model.dao;

import org.missionarogya.sherp.model.dao.object.InterviewAnswers;
import org.missionarogya.sherp.model.dao.object.InterviewDetails;
import org.springframework.stereotype.Repository;
@Repository("AppDao")
public class AppDaoImpl extends AbstractDao implements AppDao {

	public void saveAnswer(InterviewAnswers answer) {
		// TODO Auto-generated method stub
		persist(answer);
	}

	public void saveInterview(InterviewDetails interview) {
		// TODO Auto-generated method stub
		persist(interview);
		
	}

}
